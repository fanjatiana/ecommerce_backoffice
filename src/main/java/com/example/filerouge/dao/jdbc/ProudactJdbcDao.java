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
        String query = "INSERT INTO products (nameProduct, descriptionProduct, PriceProduct, selectedProduct, photoProduct, idCategory) VALUES (?, ?, ?, ?, ?, ?)";
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
        String query = "SELECT p.idProduct, p.nameProduct, p.descriptionProduct, p.PriceProduct, p.selectedProduct, p.photoProduct,c.idCategory, c.nameCategory, c.descriptionCategory " +
                "FROM products p " +
                "INNER JOIN categories c ON p.idCategory = c.idCategory";
        List<Product> productList = new ArrayList<>();

        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);

            while (result.next()) {
                Product p = new Product(
                        result.getInt("idProduct"),
                        result.getString("nameProduct"),
                        result.getString("descriptionProduct"),
                        result.getDouble("PriceProduct"),
                        result.getBoolean("selectedProduct"),
                        result.getString("photoProduct"),
                        new Category(result.getInt("idCategory"), result.getString("nameCategory"),result.getString("descriptionCategory"))
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
        String query = "SELECT p.idProduct, p.nameProduct, p.descriptionProduct, p.PriceProduct, p.selectedProduct, p.photoProduct,c.idCategory, c.nameCategory, c.descriptionCategory " +
                "FROM products p " +
                "INNER JOIN categories c ON p.idCategory = c.idCategory " +
                "WHERE p.idProduct = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, integer);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return new Product(
                        result.getInt("idProduct"),
                        result.getString("nameProduct"),
                        result.getString("descriptionProduct"),
                        result.getDouble("PriceProduct"),
                        result.getBoolean("selectedProduct"),
                        result.getString("photoProduct"),
                        new Category(result.getInt("idCategory"), result.getString("nameCategory"),result.getString("descriptionCategory"))
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
        String query = "UPDATE products SET nameProduct = ?, descriptionProduct = ?, PriceProduct = ?, selectedProduct = ?, photoProduct = ?, idCategory = ? WHERE idProduct = ?";
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
        String query = "DELETE FROM products WHERE idProduct = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, entity.getIdProduct());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
