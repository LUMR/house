package com.lumr.house.servlet;

import com.lumr.house.entity.District;
import com.lumr.house.service.DistrictService;
import com.lumr.house.service.impl.DistrictServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lumr on 2017/4/11.
 */
@WebServlet(name = "DistrictServlet",urlPatterns = "/getdist")
public class DistrictServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DistrictService service = new DistrictServiceImpl();
        List<District> list = service.getAllDistrict();
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        for (District district:list) {
            out.print("<option value="+district.getId()+">"+district.getName()+"</option>");
        }
        out.flush();
        out.close();
    }
}
