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
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name != null && password != null){
            UserService service = new UserServiceImpl();
            Users login_user = new Users(name,password);
            Users user = service.login(login_user);
            if (user != null){
                System.out.println("登陆成功");
                request.getSession().setAttribute("user",user);
                response.sendRedirect("/index.jsp");
            }else {
                System.out.println("登陆失败");
                response.sendRedirect("login.jsp");
            }
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
