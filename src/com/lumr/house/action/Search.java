package com.lumr.house.action;

import com.lumr.house.entity.District;
import com.lumr.house.entity.House;
import com.lumr.house.entity.Types;
import com.lumr.house.service.DistrictService;
import com.lumr.house.service.HouseService;
import com.lumr.house.service.TypesService;
import com.lumr.house.service.impl.DistrictServiceImpl;
import com.lumr.house.service.impl.HouseServiceImpl;
import com.lumr.house.service.impl.TypesServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by fsweb on 17-4-18.
 */
public class Search extends ActionSupport {
    private com.lumr.house.entity.Search search;
    private List<District> districts;
    private List<Types> types;
    private List<House> houses;
    private String title;
    private int page;
    private int price;
    private int floorage;
    private int street_id;
    private int type_id;

    @Override
    public String execute() throws Exception {
        search = new com.lumr.house.entity.Search(title, price, floorage, street_id, type_id);
        if (search != null) {
            HouseService service = new HouseServiceImpl();
            houses = service.getHouses(search, 0);
            ActionContext.getContext().getSession().put("search", search);
        }
        getDetail();
        return SUCCESS;
    }

    public String next() throws Exception {
        search = (com.lumr.house.entity.Search) ActionContext.getContext().getSession().get("search");
        if (search == null)
            return INPUT;
        HouseService service = new HouseServiceImpl();
        houses = service.getHouses(search, page);
        getDetail();
        return SUCCESS;
    }

    private void getDetail() {
        DistrictService districtService = new DistrictServiceImpl();
        districts = districtService.getAllDistrict();

        TypesService typesService = new TypesServiceImpl();
        types = typesService.getAllTypes();
    }

    public List<District> getDistricts() {
        return districts;
    }


    public List<Types> getTypes() {
        return types;
    }


    public List<House> getHouses() {
        return houses;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(String page) {
        try {
            this.page = Integer.parseInt(page);
        } catch (NumberFormatException e) {
            this.page = 0;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFloorage() {
        return floorage;
    }

    public void setFloorage(int floorage) {
        this.floorage = floorage;
    }

    public int getStreet_id() {
        return street_id;
    }

    public void setStreet_id(int street_id) {
        this.street_id = street_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
