package com.lumr.house.test;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.District;
import com.lumr.house.entity.House;
import com.lumr.house.entity.Street;
import com.lumr.house.service.HouseService;
import com.lumr.house.service.impl.HouseServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by fsweb on 17-4-11.
 */
public class Test extends BaseDao {
    public static void main(String[] args) {
        Test test = new Test();
        test.getStreetHouses();
    }

    private void query() {
        Session session = getSession();
        session.beginTransaction();
        String hql = "select houses from Users as user where user.id = 1003";
        List<House> list = session.createQuery(hql).list();
        for (House house : list) {
            System.out.println(house.getTitle());
        }
        session.getTransaction().commit();
    }

    private void addStreet() {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try {

            District district = (District) session.get(District.class, 1005);
            Street st = new Street("林和西");
            Street st1 = new Street("西朗");
            Street st2 = new Street("石壁");
            Street st3 = new Street("石牌桥");
            session.merge(st2);
            session.save(st3);
            ts.commit();
            System.out.println(st2.getId());
            System.out.println(st3.getId());
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
        }
    }

    private void getPages() {
        HouseService service = new HouseServiceImpl();
        System.out.println(service.getHousesPages());
    }

    //显示街道及其房屋信息
    private void getStreetHouses() {
        session = getSession();
        session.beginTransaction();
        String hql;
        //fetch抓取,这样可以直接一个指令查完全部信息
        hql = "from Street a inner join fetch a.houses";
        //新建一个类接收查询特定列的结果
        hql = "select new com.lumr.house.entity.Search(h.title,h.price,h.floorage,h.id,h.typeId) from House h";
        //子查询,存在房租少于3000的房子的街道
        hql = "from Street s where s.id in (select h.streetId from House h where h.price <3000 )";
        hql = "from Street s where 3000 >any(select h.price from s.houses h)";

        //查询每条街的平均房价
        hql = "select s.name,avg(h.price) from Street s left join s.houses h group by s.name";

        //
        hql = "select d.name,d.id from District d inner join d.streets s where (s.id) =1001 ";

        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        for (Object[] a : list) {
            System.out.println(a[0] + "\t" + a[1]);
        }
        /*
        List<Street> streets = session.createQuery(hql).list();
        for (Street street : streets) {
            System.out.println(street.getName() + ":");
            for (House house : street.getHouses()) {
                System.out.println(house.getTitle() + "\t");
            }
        }
        */


    }
}
