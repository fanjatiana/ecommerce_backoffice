package com.example.filerouge.servlet;

import com.example.filerouge.model.Category;
import com.example.filerouge.model.Product;
import com.example.filerouge.service.CategoryService;
import com.example.filerouge.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = CategoryListServlet.URL)
public class CategoryListServlet extends HttpServlet {
    public static final String URL = "/auth/list-category";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.fetchAllCategory();

        req.setAttribute("categories",categoryList);
        req
                .getRequestDispatcher("/WEB-INF/list-category.jsp")
                .forward(req,resp);
    }
}
