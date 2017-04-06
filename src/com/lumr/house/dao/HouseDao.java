package com.lumr.house.dao;

import com.lumr.house.entity.House;
import com.lumr.house.entity.Users;

import java.util.List;

/**
 * Created by fsweb on 17-4-6.
 */
public interface HouseDao {
    List<House> getAllHouses();
    List<House> getHouses(Users users);
    int addHouse(House house);
    int updateHouse(House house);
    int deleteHouse(House house);
}
