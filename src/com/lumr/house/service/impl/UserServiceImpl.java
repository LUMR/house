package com.lumr.house.service.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.dao.UserDao;
import com.lumr.house.dao.impl.UserDaoImpl;
import com.lumr.house.entity.Users;
import com.lumr.house.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created by lumr on 2017/4/6.
 */
public class UserServiceImpl extends BaseDao implements UserService {
    @Override
    public int checkUser(String name) {
        Session session= getSession();
        session.beginTransaction();
        String hql = "select name from Users where name = ?";
        List<String> list = session.createQuery(hql)
                .setString(0,name)
                .list();
        if (list.size()>0)
            return 1;
        else
            return 0;
    }

    @Override
    public Users login(Users user) {
        UserDao dao = new UserDaoImpl();
        Users users = dao.getUser(user);
        if (users==null)
            return null;
        if (users.getName().equals(user.getName()))
            return users;
        else
            return null;
    }

    @Override
    public int register(Users user) {
        return saveObj(user);
    }
}
