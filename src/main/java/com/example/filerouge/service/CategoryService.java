package com.example.filerouge.service;

import com.example.filerouge.dao.jdbc.CategoryJdbcDao;
import com.example.filerouge.model.Category;


import java.util.List;

public class CategoryService {
    CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
    public List<Category> fetchAllCategory() {
        return categoryJdbcDao.findAll();
    }
    public Category createCategory(String nameCategory, String descriptionCategory) {
        Category categoryToCreate = new Category(nameCategory, descriptionCategory);
        return categoryJdbcDao.create(categoryToCreate);
    }
    public Category fetchProductById(Integer id) {
        return categoryJdbcDao.findById(id);
    }
    public void delete(Integer categoryId) {
        Category categoryToDelete = categoryJdbcDao.findById(categoryId);
        categoryJdbcDao.delete(categoryToDelete);
    }
    public void update(Category categoryId) {
        categoryJdbcDao.update(categoryId);
    }
}
