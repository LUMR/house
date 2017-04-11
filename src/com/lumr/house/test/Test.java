package com.lumr.house.test;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.District;
import com.lumr.house.entity.House;
import com.lumr.house.entity.Street;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by fsweb on 17-4-11.
 */
public class Test extends BaseDao {
    public static void main(String[] args) {
        Test test = new Test();
        test.addStreet();
    }

    private void query(){
        Session session = getSession();
        session.beginTransaction();
        String hql = "select houses from Users as user where user.id = 1003";
        List<House> list = session.createQuery(hql).list();
        for (House house:list){
            System.out.println(house.getTitle());
        }
        session.getTransaction().commit();
    }

    private void addStreet(){
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try {

            District district = (District) session.get(District.class,1005);
            Street st = new Street("林和西");
            Street st1 = new Street("西朗");
            Street st2 = new Street("石壁");
            Street st3 = new Street("石牌桥");
            session.merge(st2);
            session.save(st3);
            ts.commit();
            System.out.println(st2.getId());
            System.out.println(st3.getId());
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
        }
    }
}
