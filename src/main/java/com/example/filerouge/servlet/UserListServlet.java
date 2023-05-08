package com.example.filerouge.servlet;

import com.example.filerouge.model.Category;
import com.example.filerouge.model.User;
import com.example.filerouge.service.CategoryService;
import com.example.filerouge.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = UserListServlet.URL)
public class UserListServlet extends HttpServlet {
    public static final String URL = "/auth/list-user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> userList = userService.fetchAllUser();


        req.setAttribute("users",userList);
        req
                .getRequestDispatcher("/WEB-INF/list-user.jsp")
                .forward(req,resp);
    }
}
