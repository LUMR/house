package com.lumr.house.service.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.House;
import com.lumr.house.entity.Street;
import com.lumr.house.entity.Types;
import com.lumr.house.entity.Users;
import com.lumr.house.service.HouseService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by lumr on 2017/4/6.
 */
public class HouseServiceImpl extends BaseDao implements HouseService {
    public static int maxResult = 5;
    @Override
    public List<House> getAllHouses() {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try{
            Query query = session.createQuery("from House ");
            return query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
            return null;
        }
    }

    @Override
    public List<House> getAllHouses(int pages) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try{
            Query query = session.createQuery("from House ");
            query.setFirstResult(pages*maxResult);
            query.setMaxResults(maxResult);
            return query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
            return null;
        }
    }

    @Override
    public List<House> getHouses(Users users) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try{
            Query query = session.createQuery("from House where userId = ?");
            query.setString(0,users.getName());
            return query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
            return null;
        }
    }

    @Override
    public List<House> getHouses(Street street) {
        return null;
    }

    @Override
    public List<House> getHouses(Types types) {
        return null;
    }

    @Override
    public int addHouse(House house) {
        return saveObj(house);
    }

    @Override
    public int updateHouse(House house) {
        return 0;
    }

    @Override
    public int deleteHouse(House house) {
        return 0;
    }
}
