package com.example.filerouge.servlet;

import com.example.filerouge.model.Product;
import com.example.filerouge.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = ProductDeleteServlet.URL)
public class ProductDeleteServlet extends HttpServlet {
    public static final String URL = "/delete-product";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ProductService productService = new ProductService();
            Integer productId = Integer.parseInt(req.getParameter("id"));
            productService.delete(productId);
            resp.sendRedirect(req.getContextPath() + ProductListServlet.URL);
        }

}
