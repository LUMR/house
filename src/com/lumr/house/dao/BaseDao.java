package com.lumr.house.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by fsweb on 17-4-6.
 */
public class BaseDao {
    private static Configuration configuration;
    private static SessionFactory factory;

    static {
        configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        return factory.getCurrentSession();
    }

}
