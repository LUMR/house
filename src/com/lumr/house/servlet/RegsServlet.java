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

/**
 * Created by lumr on 2017/4/6.
 */
@WebServlet(name = "RegsServlet", urlPatterns = "/regs")
public class RegsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String userName = request.getParameter("username");
        if (name != null && password != null && telephone != null && userName != null) {
            Users user = new Users(name, password, telephone, userName);
            System.out.println(userName+name);
            UserService service = new UserServiceImpl();
            int result = service.register(user);
            if (result == 1) {
                System.out.println("注册成功");
                response.sendRedirect("/index");
            } else {
                System.out.println("注册失败");
                response.sendRedirect("regs.jsp");
            }
        } else {
            response.sendRedirect("/regs.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
