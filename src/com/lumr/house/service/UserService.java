package com.lumr.house.service;

import com.lumr.house.entity.Users;

/**
 * Created by fsweb on 17-4-6.
 */
public interface UserService {
    Users login(Users user);
    int register(Users user);
}