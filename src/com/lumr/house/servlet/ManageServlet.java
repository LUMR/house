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
 * Created by fsweb on 17-4-14.
 */
@WebServlet(name = "ManageServlet",urlPatterns = "/guanli")
public class ManageServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users)req.getSession().getAttribute("user");
        if (user == null)
            resp.sendRedirect("/login.jsp");
        else {
            UserService service = new UserServiceImpl();
            Users newUser = service.getUser(user);
            req.setAttribute("user", newUser);
            req.getRequestDispatcher("/guanli.jsp").forward(req, resp);
        }
    }
}
