package com.lumr.house.servlet;

import com.lumr.house.entity.District;
import com.lumr.house.entity.House;
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
 * Created by lumr on 2017/4/6.
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int page;
        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 0;
        }

        HouseService service = new HouseServiceImpl();
        int Maxpage = service.getHousesPages();
        if (page >= Maxpage || page < 0)
            page = Maxpage-1;
        List<House> houses = service.getAllHouses(page);

        DistrictService districtService = new DistrictServiceImpl();
        List<District> districts = districtService.getAllDistrict();

        TypesService typesService = new TypesServiceImpl();
        List<Types> types = typesService.getAllTypes();

        req.setAttribute("types", types);
        req.setAttribute("districts", districts);
        req.setAttribute("houses", houses);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
