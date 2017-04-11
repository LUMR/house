package com.lumr.house.service;

import com.lumr.house.entity.Street;

import java.util.List;

/**
 * Created by fsweb on 17-4-11.
 */
public interface StreetService {
    List<Street> getAllStreets();
    List<Street> getStreets(int did);
    Street getStreet(String name);
    int updateStreet(Street street);
}
