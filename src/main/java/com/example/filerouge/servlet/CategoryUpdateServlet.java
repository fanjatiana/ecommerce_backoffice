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

@WebServlet(urlPatterns = CategoryUpdateServlet.URL)
public class CategoryUpdateServlet extends HttpServlet {
    public static final String URL = "/update-category";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.fetchProductById(id);
        req.setAttribute("id", id);
        req.setAttribute("nameCategory", category.getNameCategory());
        req.setAttribute("descriptionCategory", category.getDescriptionCategory());

        req
                .getRequestDispatcher("/WEB-INF/update-category-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String nameCategory = req.getParameter("nameCategory");
        String descriptionCategory = req.getParameter("descriptionCategory");

        CategoryService categoryService = new CategoryService();
        Category updatedCategory = new Category(id, nameCategory, descriptionCategory);
        categoryService.update(updatedCategory);
        resp.sendRedirect(req.getContextPath() + CategoryListServlet.URL);
    }
}
