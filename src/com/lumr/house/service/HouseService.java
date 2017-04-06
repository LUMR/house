package com.lumr.house.service;

import com.lumr.house.entity.House;
import com.lumr.house.entity.Street;
import com.lumr.house.entity.Types;
import com.lumr.house.entity.Users;

import java.util.List;

/**
 * Created by fsweb on 17-4-6.
 */
public interface HouseService {
    List<House> getAllHouses();
    List<House> getHouses(Users users);
    List<House> getHouses(Street street);
    List<House> getHouses(Types types);
    int addHouse(House house);
    int updateHouse(House house);
    int deleteHouse(House house);
}
