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

@WebServlet(urlPatterns = CategoryDeleteServlet.URL)
public class CategoryDeleteServlet extends HttpServlet {
    public static final String URL = "/delete-category";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            CategoryService categoryService = new CategoryService();
            Integer categoryId = Integer.parseInt(req.getParameter("id"));
            categoryService.delete(categoryId);
            resp.sendRedirect(req.getContextPath() + CategoryListServlet.URL);
        }

}
