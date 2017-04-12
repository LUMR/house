package com.lumr.house.servlet;

import com.lumr.house.entity.House;
import com.lumr.house.entity.Users;
import com.lumr.house.service.HouseService;
import com.lumr.house.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lumr on 2017/4/6.
 */
@WebServlet(name = "FabuServlet",urlPatterns = "/fabu")
public class FabuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String type_id = request.getParameter("type_id");
        String floorage_s = request.getParameter("floorage");
        String price_s = request.getParameter("price");
        String house_date = request.getParameter("houseDate");
        String district_id = request.getParameter("district_id");
        String street_id = request.getParameter("street_id");
        String contact = request.getParameter("contact");
        String description = request.getParameter("description");

        int typeId = Integer.parseInt(type_id);
        int districtId = Integer.parseInt(district_id);
        int streetId = Integer.parseInt(street_id);
        int price = Integer.parseInt(price_s);
        int floorage = Integer.parseInt(floorage_s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date houseDate;
        try {
            houseDate = sdf.parse(house_date);
        } catch (ParseException e) {
            houseDate = new Date();
        }
        Users user = (Users) request.getSession().getAttribute("user");
        if (user ==null){
            response.sendRedirect("/login.jsp");
        }
        House house = new House(user.getId(),typeId,streetId,title,description,price,houseDate,floorage,contact);
        HouseService service = new HouseServiceImpl();
        int result = service.addHouse(house);
        response.sendRedirect("/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
