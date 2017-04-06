package com.lumr.house.service.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.dao.UserDao;
import com.lumr.house.dao.impl.UserDaoImpl;
import com.lumr.house.entity.Users;
import com.lumr.house.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Created by lumr on 2017/4/6.
 */
public class UserServiceImpl extends BaseDao implements UserService {
    @Override
    public Users login(Users user) {
        UserDao dao = new UserDaoImpl();
        Users users = dao.getUser(user.getName());
        if (users==null)
            return null;
        if (users.getName().equals(user.getName()))
            return users;
        else
            return null;
    }

    @Override
    public int register(Users user) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        try {
            session.save(user);
            ts.commit();
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
            return 0;
        }
    }
}
