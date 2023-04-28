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

@WebServlet(urlPatterns = AddProductServlet.URL)
public class AddProductServlet extends HttpServlet {
    public static final String URL = "/add-product";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = new CategoryService().fetchAllCategory();
        req.setAttribute("categories", categories);
        req
                .getRequestDispatcher("/WEB-INF/add-product-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameProduct = req.getParameter("nameProduct");
        String descriptionProduct = req.getParameter("descriptionProduct");
        Double PriceProduct = Double.valueOf(req.getParameter("PriceProduct"));
        String photoProduct = req.getParameter("photoProduct");
        Boolean selectedProduct = false;
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        try {
            new ProductService().createProduct(nameProduct,descriptionProduct,PriceProduct,selectedProduct,photoProduct,idCategory);
            resp.sendRedirect("list-product");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + AddProductServlet.URL + "?error=true");
        }
    }
}
