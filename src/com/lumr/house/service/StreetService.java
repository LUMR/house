package com.lumr.house.service;

import com.lumr.house.entity.Street;

/**
 * Created by fsweb on 17-4-11.
 */
public interface StreetService {
    Street getStreet(String name);
    int updateStreet(Street street);
}
