package com.lumr.house.action;

import com.lumr.house.entity.House;
import com.lumr.house.entity.Users;
import com.lumr.house.service.HouseService;
import com.lumr.house.service.impl.HouseServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by fsweb on 17-4-19.
 */
public class HouseDetail extends ActionSupport {
    private int hid;
    House house;

    @Override
    public String execute() throws Exception {
        HouseService service = new HouseServiceImpl();
        house = service.getHouse(hid);
        return SUCCESS;
    }

    public String update() {
        HouseService service = new HouseServiceImpl();
        house = service.getHouse(hid);
        Users user = (Users) ActionContext.getContext().getSession().get("user");
        if (user == null) {
            addActionError("你还没有登录,请先登录");
            return LOGIN;
        }
        if (user.getId() == house.getUserId())
            return SUCCESS;
        else {
            addActionError("你没有权限修改该房屋.");
            return ERROR;
        }
    }

    public House getHouse() {
        return house;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(String hid) {
        try {
            this.hid = Integer.valueOf(hid);
        } catch (NumberFormatException e) {
            this.hid = 0;
        }
    }
}
