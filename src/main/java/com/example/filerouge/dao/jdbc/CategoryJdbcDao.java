package com.example.filerouge.dao.jdbc;

import com.example.filerouge.dao.ConnectionManager;
import com.example.filerouge.dao.crud.CategoryDao;
import com.example.filerouge.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao {
    @Override
    public Category create(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO categories (name_category,description_category) VALUES (?,?)";
        try (PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getNameCategory());
            pst.setString(2, entity.getDescriptionCategory());
            int result = pst.executeUpdate();
            if (result == 1) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    return new Category(id, entity.getNameCategory(),entity.getDescriptionCategory());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id_category, name_category,description_category FROM categories";
        List<Category> categoryList = new ArrayList<>();

        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);

            while (result.next()) {
                Category category = new Category(
                        result.getInt("id_category"),
                        result.getString("name_category"),
                        result.getString(("description_category"))
                );
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(Integer integer) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id_category, name_category,description_category  FROM categories WHERE id_category = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, integer);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return new Category(
                        result.getInt("id_category"),
                        result.getString("name_category"),
                        result.getString("description_category")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "UPDATE categories SET name_category = ?,description_category = ? WHERE id_category = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, entity.getNameCategory());
            pst.setString(2, entity.getDescriptionCategory());
            pst.setInt(3, entity.getIdCategory());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "DELETE FROM categories WHERE id_category = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, entity.getIdCategory());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
