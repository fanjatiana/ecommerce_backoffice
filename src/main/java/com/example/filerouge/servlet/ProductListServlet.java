package com.example.filerouge.servlet;

import com.example.filerouge.model.Product;
import com.example.filerouge.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ProductListServlet.URL)
public class ProductListServlet extends HttpServlet {
    public static final String URL = "/list-product";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        List<Product> productList = productService.fetchAllProduct();

        req.setAttribute("products",productList);
        req
                .getRequestDispatcher("/WEB-INF/list-product.jsp")
                .forward(req,resp);
    }
}
