package com.lumr.house.servlet;

import com.lumr.house.entity.House;
import com.lumr.house.service.HouseService;
import com.lumr.house.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fsweb on 17-4-12.
 */
@WebServlet(name = "DetailServlet",urlPatterns = "/details")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int hid;
        try{
            hid = Integer.parseInt(request.getParameter("hid"));
        }catch (NumberFormatException e){
            hid = 0;
        }
        HouseService service = new HouseServiceImpl();
        House house = service.getHouse(hid);
        request.setAttribute("house",house);
        request.getRequestDispatcher("details.jsp").forward(request,response);
    }
}
