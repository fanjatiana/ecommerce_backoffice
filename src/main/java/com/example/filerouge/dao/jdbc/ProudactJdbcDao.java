package com.example.filerouge.dao.jdbc;

import com.example.filerouge.dao.ConnectionManager;
import com.example.filerouge.dao.crud.ProductDao;
import com.example.filerouge.model.Category;
import com.example.filerouge.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProudactJdbcDao implements ProductDao {
    @Override
    public Product create(Product entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO products (name_product, description_product, price_product, selected_product, photo_product, category_id_category) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getNameProduct());
            pst.setString(2, entity.getDescriptionProduct());
            pst.setDouble(3, entity.getPriceProduct());
            pst.setBoolean(4, entity.isSelectedProduct());
            pst.setString(5, entity.getPhotoProduct());
            pst.setInt(6, entity.getCategory().getIdCategory());
            int result = pst.executeUpdate();
            if (result == 1) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    Integer id = generatedKeys.getInt(1);
                    entity.setIdProduct(id);
                    return entity;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT p.id_product, p.name_product, p.description_product, p.price_product, p.selected_product, p.photo_product,c.id_category, c.name_category, c.description_category " +
                "FROM products p " +
                "INNER JOIN categories c ON p.category_id_category = c.id_category";
        List<Product> productList = new ArrayList<>();

        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);

            while (result.next()) {
                Product p = new Product(
                        result.getInt("id_product"),
                        result.getString("name_product"),
                        result.getString("description_product"),
                        result.getDouble("price_product"),
                        result.getBoolean("selected_product"),
                        result.getString("photo_product"),
                        new Category(result.getInt("id_category"), result.getString("name_category"),result.getString("description_category"))
                );
                productList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(Integer integer) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT p.id_product, p.name_product, p.description_product, p.price_product, p.selected_product, p.photo_product,c.id_category, c.name_category, c.description_category " +
                "FROM products p " +
                "INNER JOIN categories c ON p.category_id_category = c.id_category " +
                "WHERE p.id_product = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, integer);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return new Product(
                        result.getInt("id_product"),
                        result.getString("name_product"),
                        result.getString("description_product"),
                        result.getDouble("price_product"),
                        result.getBoolean("selected_product"),
                        result.getString("photo_product"),
                        new Category(result.getInt("id_category"), result.getString("name_category"),result.getString("description_category"))
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
    public void update(Product entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "UPDATE products SET name_product = ?, description_product = ?, price_product = ?, selected_product = ?, photo_product = ?, category_id_category = ? WHERE id_product = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, entity.getNameProduct());
            pst.setString(2, entity.getDescriptionProduct());
            pst.setDouble(3, entity.getPriceProduct());
            pst.setBoolean(4, entity.isSelectedProduct());
            pst.setString(5, entity.getPhotoProduct());
            pst.setInt(6, entity.getCategory().getIdCategory());
            pst.setInt(7, entity.getIdProduct());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "DELETE FROM products WHERE id_product = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, entity.getIdProduct());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
