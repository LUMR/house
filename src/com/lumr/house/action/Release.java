package com.lumr.house.action;

import com.lumr.house.entity.House;
import com.lumr.house.entity.Users;
import com.lumr.house.service.HouseService;
import com.lumr.house.service.impl.HouseServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by fsweb on 17-4-18.
 */
public class Release extends ActionSupport {
    private String title;
    private int type_id;
    private int floorage;
    private int price;
    private Date houseDate;
    private int district_id;
    private int street_id;
    private String contact;
    private String description;

    @Override
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Users user = (Users) session.get("user");
        if (user == null)
            return LOGIN;
        House house = new House(user.getId(), type_id, street_id, title, description, price, houseDate, floorage, contact);
        HouseService service = new HouseServiceImpl();
        int result = service.addHouse(house);
        if (result > 0)
            return SUCCESS;
        else {
            addActionError("添加失败,请稍后重试");
            return ERROR;
        }
    }

    @Override
    public void validate() {
        //验证输入是否完整
        if (title.equals("") || contact.equals("") || description.equals(""))
            addFieldError("detail", "请填写完整信息");
        if (type_id == 0 || floorage == 0 || price == 0 || district_id == 0 || street_id == 0)
            addFieldError("number", "数字未填写或填写错误");
        if (houseDate == null)
            addFieldError("date", "请填写正确的日期");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        try {
            this.type_id = Integer.parseInt(type_id);
        } catch (NumberFormatException e) {
            this.type_id = 0;
        }
    }

    public int getFloorage() {
        return floorage;
    }

    public void setFloorage(String floorage) {
        try {
            this.floorage = Integer.parseInt(floorage);
        } catch (NumberFormatException e) {
            this.floorage = 0;
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        try {
            this.price = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            this.price = 0;
        }
    }

    public Date getHouseDate() {
        return houseDate;
    }

    public void setHouseDate(String houseDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.houseDate = sdf.parse(houseDate);
        } catch (ParseException e) {
            this.houseDate = null;
        }
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getStreet_id() {
        return street_id;
    }

    public void setStreet_id(int street_id) {
        this.street_id = street_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
