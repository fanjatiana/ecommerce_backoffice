package com.example.filerouge.servlet;

import com.example.filerouge.model.Category;
import com.example.filerouge.model.Product;
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

@WebServlet(urlPatterns = ProductUpdateServlet.URL)
@MultipartConfig
public class ProductUpdateServlet extends HttpServlet {
    public static final String URL = "/auth/update-product";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = new CategoryService().fetchAllCategory();
        req.setAttribute("categories", categoryList);
        ProductService productService = new ProductService();
        List<Product> productList = productService.fetchAllProduct();
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.fetchProductById(id);
        req.setAttribute("id", id);
        req.setAttribute("nameProduct", product.getNameProduct());
        req.setAttribute("descriptionProduct", product.getDescriptionProduct());
        req.setAttribute("PriceProduct", product.getPriceProduct());
        req.setAttribute("photoProduct", product.getPhotoProduct());
        req.setAttribute("idCategory", product.getCategory().getIdCategory());

        req.setAttribute("products", productList);
        req
                .getRequestDispatcher("/WEB-INF/update-product-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String nameProduct = req.getParameter("nameProduct");
        String descriptionProduct = req.getParameter("descriptionProduct");
        Double priceProduct = Double.valueOf(req.getParameter("priceProduct"));
        Boolean selectedProduct = false;
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
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.fetchProductById(idCategory);
        ProductService productService = new ProductService();
        Product updatedProduct = new Product(id, nameProduct, descriptionProduct, priceProduct, selectedProduct, photoProduct, category);
        productService.update(updatedProduct);
        resp.sendRedirect(req.getContextPath() + ProductListServlet.URL);
    }
}
