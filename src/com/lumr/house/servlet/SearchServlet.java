package com.lumr.house.servlet;

import com.lumr.house.entity.House;
import com.lumr.house.entity.Search;
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
 * Created by fsweb on 17-4-11.
 */
@WebServlet(name = "SearchServlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        int floorage = Integer.parseInt(request.getParameter("floorage"));
        int streetId = Integer.parseInt(request.getParameter("street_id"));
        int typeId = Integer.parseInt(request.getParameter("type_id"));

        Search search = new Search(title,price,floorage,streetId,typeId);
        HouseService service = new HouseServiceImpl();
        List<House> houses = service.getHouses(search);
        request.setAttribute("houses",houses);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
