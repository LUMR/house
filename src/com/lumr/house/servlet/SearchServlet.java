package com.lumr.house.servlet;

import com.lumr.house.entity.District;
import com.lumr.house.entity.House;
import com.lumr.house.entity.Search;
import com.lumr.house.entity.Types;
import com.lumr.house.service.DistrictService;
import com.lumr.house.service.HouseService;
import com.lumr.house.service.TypesService;
import com.lumr.house.service.impl.DistrictServiceImpl;
import com.lumr.house.service.impl.HouseServiceImpl;
import com.lumr.house.service.impl.TypesServiceImpl;

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
@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Search search;
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        int floorage = Integer.parseInt(request.getParameter("floorage"));
        int streetId = Integer.parseInt(request.getParameter("street_id"));
        int typeId = Integer.parseInt(request.getParameter("type_id"));
        search = new Search(title, price, floorage, streetId, typeId);
        if (search != null) {
            HouseService service = new HouseServiceImpl();
            request.getSession().setAttribute("search", search);
            List<House> houses = service.getHouses(search, 0);
            request.setAttribute("houses", houses);
        }
        getDetail(request);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page_s = request.getParameter("page");
        int page = 0;
        if (page_s != null)
            page = Integer.parseInt(page_s);
        Search search = (Search) request.getSession().getAttribute("search");
        if (search != null) {
            HouseService service = new HouseServiceImpl();
            List<House> houses = service.getHouses(search, page);
            request.setAttribute("houses", houses);
        }
        request.setAttribute("page",page);
        getDetail(request);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    private void getDetail(HttpServletRequest req){
        DistrictService districtService = new DistrictServiceImpl();
        List<District> districts = districtService.getAllDistrict();

        TypesService typesService = new TypesServiceImpl();
        List<Types> types = typesService.getAllTypes();

        req.setAttribute("types", types);
        req.setAttribute("districts", districts);
    }
}
