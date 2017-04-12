package com.lumr.house.service.impl;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.Types;
import com.lumr.house.service.TypesService;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by fsweb on 17-4-12.
 */
public class TypesServiceImpl extends BaseDao implements TypesService {
    @Override
    public List<Types> getAllTypes() {
        Session session = getSession();
        return session.createQuery("from Types ").list();
    }
}
