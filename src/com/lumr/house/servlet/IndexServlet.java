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
import java.util.List;

/**
 * Created by lumr on 2017/4/6.
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HouseService service = new HouseServiceImpl();
        List<House> houses = service.getAllHouses();
        req.setAttribute("houses",houses);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
