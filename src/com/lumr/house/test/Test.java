package com.lumr.house.test;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.House;
import com.lumr.house.entity.Street;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by fsweb on 17-4-11.
 */
public class Test extends BaseDao {
    public static void main(String[] args) {
        Session session = getSession();
        session.beginTransaction();
        String hql = "from Street ";
        List<Street> list = session.createQuery(hql).list();
        for (Street st:list){
            System.out.println(st.getName()+":");
            for (House house:st.getHouses()){
                System.out.println(house.getTitle());
            }
            System.out.println("*********");
        }
    }
}
