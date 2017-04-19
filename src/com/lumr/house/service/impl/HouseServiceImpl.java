package com.lumr.house.service.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.House;
import com.lumr.house.entity.Search;
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

    @Override
    public List<House> getAllHouses() {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try {
            Query query = session.createQuery("from House ");
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
            return null;
        }
    }

    @Override
    public List<House> getAllHouses(int pages) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try {
            Query query = session.createQuery("from House ");
            query.setFirstResult(pages * maxResult);
            query.setMaxResults(maxResult);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
            return null;
        }
    }

    @Override
    public List<House> getHouses(Users users) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try {
            Query query = session.createQuery("from House where userId = ?");
            query.setString(0, users.getName());
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
            return null;
        }
    }

    @Override
    public List<House> getHouses(Search search,int page) {
        Session session = getSession();
        session.beginTransaction();
        String hql = "from House where 1=1";
        if (search.getTitle() != "")
            hql += " and title like :title";
        if (search.getPriceLv() > 0) {
            hql += " and price < :MaxPrice";
            hql += " and price > :MinPrice";
        }
        if (search.getStreetId() > 0)
            hql += " and streetId = :streetId";
        if (search.getTypeId() > 0)
            hql += " and typeId = :typeId";
        if (search.getFloorage() > 0) {
            hql += " and floorage < :MaxAge";
            hql += " and floorage > :MinAge";
        }
        Query query = session.createQuery(hql);
        query.setProperties(search);
        query.setFirstResult(page*maxResult);
        query.setMaxResults(maxResult);
        return query.list();
    }

    @Override
    public int getHousesPages() {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.createQuery("select count(id) from House ");
        int result = Integer.parseInt(query.uniqueResult().toString());
        session.getTransaction().commit();
        if (result%maxResult == 0)
            return result/maxResult;
        else
            return result/maxResult+1;
    }

    @Override
    public House getHouse(int id) {
        session = getSession();
        session.beginTransaction();
        return (House)session.get(House.class,id);
    }


    @Override
    public int addHouse(House house) {
        return saveObj(house);
    }

    @Override
    public int updateHouse(House house) {
        Transaction ts = session.getTransaction();
        try {
            session.update(house);
            ts.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
            return 0;
        }
    }

    @Override
    public int deleteHouse(House house) {
        return 0;
    }
}
