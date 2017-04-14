package com.lumr.house.dao;

import com.lumr.house.entity.Users;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by fsweb on 17-4-6.
 */
public class BaseDao {
    private static Configuration configuration;
    private static SessionFactory factory;
    protected static Session session;

    static {
        configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        return factory.getCurrentSession();
    }

    /**
     * 万能查询法
     * @param hql
     * @param user
     */
    @Deprecated
    public void getQuery(String hql,Users user){
        Session session = getSession();
//        hql例如: from * where name = :name and id = :id
        Query query = session.createQuery(hql);
//        直接传对象,可以自动设定参数
        query.setProperties(user);
//        返回一个结果集,查询1次
        query.list();
//        返回一个迭代器,先查询全部结果的id,在根据id查询其他列,查询次数n+1次
        query.iterate();
    }

    public int saveObj(Object obj){
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try{
            session.save(obj);
            ts.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
            return 0;
        }
    }
}
