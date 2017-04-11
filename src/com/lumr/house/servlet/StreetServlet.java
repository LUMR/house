package com.lumr.house.servlet;

import com.lumr.house.entity.Street;
import com.lumr.house.service.StreetService;
import com.lumr.house.service.impl.StreetServiceImpl;

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
@WebServlet(name = "StreetServlet",urlPatterns = "/getstreet")
public class StreetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int did = Integer.parseInt(request.getParameter("district"));
        StreetService service = new StreetServiceImpl();
        List<Street> list = service.getStreets(did);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        for (Street street:list){
            out.write("<option value="+street.getId()+">"+street.getName()+"</option>");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
