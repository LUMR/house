package com.lumr.house.servlet;

import com.lumr.house.entity.Users;
import com.lumr.house.service.UserService;
import com.lumr.house.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fsweb on 17-4-10.
 */
@WebServlet(name = "CheckUserServlet",urlPatterns = "/checkuser")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        if (userName != null){
            UserService service = new UserServiceImpl();
            int result = service.checkUser(userName);
            PrintWriter out = response.getWriter();
            if (result == 0){
                out.print("true");
            }else
                out.print("false");
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
