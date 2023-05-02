package com.example.filerouge.service;

import com.example.filerouge.dao.jdbc.UserJdbcDao;
import com.example.filerouge.model.User;

import java.util.List;

public class UserService {
    private UserJdbcDao userJdbcDao =new UserJdbcDao();
    public User findUserByUsername(String username) {
        return userJdbcDao.findByUsername(username);
    }

    public List<User> fetchAllUser() {
        return userJdbcDao.findAll();
    }

    public User fetchUserById(int id) {
        return userJdbcDao.findById(id);
    }

    public void update(User updatedUser) {
        userJdbcDao.update(updatedUser);
    }
}
