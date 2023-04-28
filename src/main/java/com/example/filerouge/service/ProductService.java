package com.example.filerouge.service;

import com.example.filerouge.dao.jdbc.CategoryJdbcDao;
import com.example.filerouge.dao.jdbc.ProudactJdbcDao;
import com.example.filerouge.model.Category;
import com.example.filerouge.model.Product;

import java.util.List;

public class ProductService {
    ProudactJdbcDao proudactJdbcDao = new ProudactJdbcDao();
    CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
    public List<Product> fetchAllProduct() {
        return proudactJdbcDao.findAll();
    }
    public Product createProduct(String nameProduct, String descriptionProduct, double priceProduct, boolean selectedProduct, String photoProduct, Integer idCategory) {
        Category selectedCategory = categoryJdbcDao.findById(idCategory);
        Product productToCreate = new Product(nameProduct, descriptionProduct, priceProduct, selectedProduct, photoProduct,selectedCategory);
        return proudactJdbcDao.create(productToCreate);
    }
    public Product fetchProductById(Integer id) {
        return proudactJdbcDao.findById(id);
    }
    public void delete(Integer productId) {
        Product productToDelete = proudactJdbcDao.findById(productId);
        System.out.println(productToDelete.getIdProduct());
        proudactJdbcDao.delete(productToDelete);
    }
    public void update(Product productId) {
        proudactJdbcDao.update(productId);
    }
}
