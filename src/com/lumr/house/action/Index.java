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
import com.opensymphony.xwork2.Action;

import java.util.List;

/**
 * Created by lumr on 2017/4/17.
 */
public class Index implements Action {
    private String page;
    private int page_i;
    private List<Types> types;
    private List<District> districts;
    private List<House> houses;

    @Override
    public String execute() throws Exception {
        HouseService service = new HouseServiceImpl();
        int Maxpage = service.getHousesPages();
        if (page_i >= Maxpage || page_i < 0)
            page_i = Maxpage - 1;
        houses = service.getAllHouses(page_i);

        DistrictService districtService = new DistrictServiceImpl();
        districts = districtService.getAllDistrict();

        TypesService typesService = new TypesServiceImpl();
        types = typesService.getAllTypes();

        return SUCCESS;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
        try {
            page_i = Integer.parseInt(page);
        }catch (NumberFormatException e){
            page_i = 0;
        }
    }

    public int getPage_i() {
        return page_i;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }
}
