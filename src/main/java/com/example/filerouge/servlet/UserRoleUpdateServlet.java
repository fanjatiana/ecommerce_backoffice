package com.example.filerouge.servlet;

import com.example.filerouge.model.Category;
import com.example.filerouge.model.Role;
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

@WebServlet(urlPatterns = UserRoleUpdateServlet.URL)
public class UserRoleUpdateServlet extends HttpServlet {
    public static final String URL = "/auth/update-user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roleList = List.of(
                new Role(2, "admin"),
                new Role(3, "client")
        );
        req.setAttribute("roles", roleList);
        UserService userService = new UserService();
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.fetchUserById(id);
        req.setAttribute("id", id);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("password", user.getPassword());
        req.setAttribute("fullName", user.getFullName());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("address", user.getAddress());
        req.setAttribute("phoneNumber", user.getPhoneNumber());
        req.setAttribute("roleName", user.getRole().getRoleName());
        req.setAttribute("idRole", user.getRole().getIdRole());

        req
                .getRequestDispatcher("/WEB-INF/update-userrole-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        Role role = new Role(Integer.parseInt(req.getParameter("idRole")),req.getParameter("roleName"));
        UserService userService = new UserService();
        User updatedUser = new User(id, username, password, fullName, email, address, phoneNumber, role);
        userService.update(updatedUser);
        resp.sendRedirect(req.getContextPath() + UserListServlet.URL);
    }
}
