package com.example.filerouge.dao.jdbc;

import com.example.filerouge.dao.ConnectionManager;
import com.example.filerouge.dao.crud.UserDao;
import com.example.filerouge.model.Role;
import com.example.filerouge.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {
    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public List<User> findAll() {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT *  FROM users u INNER JOIN roles r ON u.role_id_role = r.id_role";
        List<User> userList = new ArrayList<>();
        try (Statement pst = connection.createStatement()) {
            ResultSet result = pst.executeQuery(query);
            while (result.next()) {
                User user = new User(
                        result.getInt("id_user"),
                        result.getString("username"),
                        result.getString("password"),
                        result.getString("full_name"),
                        result.getString("email"),
                        result.getString("address"),
                        result.getString("phone_number"),
                        new Role(result.getInt("id_role"),result.getString("role_name"))
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(Integer integer) {
        User userFound = null;
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT *  FROM users u INNER JOIN roles r ON u.role_id_role = r.id_role WHERE u.id_user = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, integer);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                Role role = new Role(resultSet.getInt("id_role"),resultSet.getString("role_name"));
                userFound = new User(idUser,username,password,fullName,email,address,phoneNumber,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }

    @Override
    public void update(User entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "UPDATE users SET username = ?, password = ?, full_name = ?, email = ?, address = ?, phone_number = ?, role_id_role = ? WHERE id_user = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, entity.getUsername());
            pst.setString(2, entity.getPassword());
            pst.setString(3, entity.getFullName());
            pst.setString(4, entity.getEmail());
            pst.setString(5, entity.getAddress());
            pst.setString(6, entity.getPhoneNumber());
            pst.setInt(7, entity.getRole().getIdRole());
            pst.setInt(8, entity.getIdUser());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User entity) {

    }
    public User findByUsername(String usernameFind) {
        User userFound = null;
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT *  FROM users u INNER JOIN roles r ON u.role_id_role = r.id_role WHERE u.username = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usernameFind);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                Role role = new Role(resultSet.getInt("id_role"),resultSet.getString("role_name"));
                userFound = new User(idUser,username,password,fullName,email,address,phoneNumber,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }
}
