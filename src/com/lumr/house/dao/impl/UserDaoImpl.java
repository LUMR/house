package com.lumr.house.dao.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.dao.UserDao;
import com.lumr.house.entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by lumr on 2017/4/6.
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public Users getUser(String name) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("from Users where name = '"+name+"'");
        List<Users> list = query.list();
        if (list.size()>0)
            return list.get(0);
        else
            return null;
    }
}
