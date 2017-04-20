package com.lumr.house.action;

import com.lumr.house.entity.District;
import com.lumr.house.entity.Street;
import com.lumr.house.entity.Types;
import com.lumr.house.service.DistrictService;
import com.lumr.house.service.StreetService;
import com.lumr.house.service.TypesService;
import com.lumr.house.service.UserService;
import com.lumr.house.service.impl.DistrictServiceImpl;
import com.lumr.house.service.impl.StreetServiceImpl;
import com.lumr.house.service.impl.TypesServiceImpl;
import com.lumr.house.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by fsweb on 17-4-18.
 */
public class GetData implements Action {
    private String name;
    private int did;
    private List<Types> types;
    private List<Street> streets;
    private List<District> districts;
    @Override
    public String execute() throws Exception {
        return null;
    }
    public String get_types(){
        TypesService service = new TypesServiceImpl();
        types = service.getAllTypes();
        return SUCCESS;
    }

    public String get_districts(){
        DistrictService service = new DistrictServiceImpl();
        districts = service.getAllDistrict();
        return SUCCESS;
    }

    public String get_streets(){
        StreetService service = new StreetServiceImpl();
        streets = service.getStreets(did);
        return SUCCESS;
    }

    public String checkUser(){
        if (name != null){
            UserService service = new UserServiceImpl();
            int result = service.checkUser(name);
            if (result == 0)
                return "true";
            else
                return "false";
        }
        return "false";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public List<Types> getTypes() {
        return types;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
