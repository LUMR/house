package com.lumr.house.dao;

import com.lumr.house.entity.Users;

/**
 * Created by lumr on 2017/4/6.
 */
public interface UserDao {
    Users getUser(String name);
}
