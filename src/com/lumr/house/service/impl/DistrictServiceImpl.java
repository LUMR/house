package com.lumr.house.service.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.District;
import com.lumr.house.service.DistrictService;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by lumr on 2017/4/11.
 */
public class DistrictServiceImpl extends BaseDao implements DistrictService {
    @Override
    public List<District> getAllDistrict() {
        Session session = getSession();
        session.beginTransaction();
        return session.createQuery("from District ").list();
    }
}
