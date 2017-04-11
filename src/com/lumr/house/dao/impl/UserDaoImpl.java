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
    public Users getUser(Users user) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        String hql = "from Users where 1=1";

        if (user.getId() != null) {
            hql += " and id = :id";
        }

        if (user.getName() != null) {
            hql += " and name = :name";
        }

        Query query = session.createQuery(hql);
        query.setProperties(user);
        return (Users)query.uniqueResult();
    }
}
