package com.example.filerouge.servlet;

import com.example.filerouge.model.Category;
import com.example.filerouge.service.CategoryService;
import com.example.filerouge.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(urlPatterns = AddProductServlet.URL)
@MultipartConfig
public class AddProductServlet extends HttpServlet {
    public static final String URL = "/auth/add-product";

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
//        String photoProduct = req.getParameter("photoProduct");
        Part photoPart = req.getPart("photoProduct");
        String photoProduct = null;
        if (photoPart != null) {
            photoProduct = photoPart.getSubmittedFileName();
            String webAppPath = getServletContext().getRealPath("/");
            String parentPath = new File(webAppPath).getParent();
            String photoPath = parentPath + "/images/" + photoProduct;
            try (InputStream inputStream = photoPart.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(photoPath)) {
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        }
        Boolean selectedProduct = false;
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        try {
            new ProductService().createProduct(nameProduct,descriptionProduct,PriceProduct,selectedProduct,photoProduct,idCategory);
            resp.sendRedirect(req.getContextPath() +"/auth/list-product");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + AddProductServlet.URL + "?error=true");
        }
    }
}
