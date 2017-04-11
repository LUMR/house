package com.lumr.house.service.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.Street;
import com.lumr.house.service.StreetService;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by lumr on 2017/4/11.
 */
public class StreetServiceImpl extends BaseDao implements StreetService {
    @Override
    public List<Street> getAllStreets() {
        Session session = getSession();
        session.beginTransaction();
        return session.createQuery("from Street ").list();
    }

    @Override
    public List<Street> getStreets(int did) {
        Session session = getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from Street where district.id = ?");
        query.setInteger(0,did);
        return query.list();
    }

    @Override
    public Street getStreet(String name) {
        return null;
    }

    @Override
    public int updateStreet(Street street) {
        return 0;
    }
}
