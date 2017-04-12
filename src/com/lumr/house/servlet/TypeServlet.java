package com.lumr.house.servlet;

import com.lumr.house.dao.BaseDao;
import com.lumr.house.entity.Types;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lumr on 2017/4/12.
 */
@WebServlet(name = "TypeServlet",urlPatterns = "/gettype")
public class TypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = BaseDao.getSession();
        session.beginTransaction();
        List<Types> list = session.createQuery("from Types ").list();
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        for (Types types:list){
            out.write("<option value="+types.getId()+">"+types.getName()+"</option>");
        }
        out.flush();
        out.close();
    }
}
