package com.lumr.house.service;

import com.lumr.house.entity.*;

import java.util.List;

/**
 * Created by fsweb on 17-4-6.
 */
public interface HouseService {
    int maxResult = 5;
    List<House> getAllHouses();
    List<House> getAllHouses(int pages);
    List<House> getHouses(Users users);
    List<House> getHouses(Search search,int page);
    int getHousesPages();
    House getHouse(int id);
    int addHouse(House house);
    int updateHouse(House house);
    int deleteHouse(House house);
}
