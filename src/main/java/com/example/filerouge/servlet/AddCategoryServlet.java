package com.example.filerouge.servlet;

import com.example.filerouge.model.Category;
import com.example.filerouge.service.CategoryService;
import com.example.filerouge.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = AddCategoryServlet.URL)
public class AddCategoryServlet extends HttpServlet {
    public static final String URL = "/auth/add-category";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req
                .getRequestDispatcher("/WEB-INF/add-category-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameCategory = req.getParameter("nameCategory");
        String descriptionCategory = req.getParameter("descriptionCategory");
        try {
            new CategoryService().createCategory(nameCategory,descriptionCategory);
            resp.sendRedirect(req.getContextPath() +"/auth/list-category");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + AddCategoryServlet.URL + "?error=true");
        }
    }
}
