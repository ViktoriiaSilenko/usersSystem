package com.spring.series.jdbc.service.impl;

import com.spring.series.jdbc.dao.UserDAO;
import com.spring.series.jdbc.model.User;
import com.spring.series.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDAO getPersonDAO() {
        return userDAO;
    }

    @Override
    @Transactional
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Override
    @Transactional
    public String insertNewUser(User user) {
        return userDAO.insertNewUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public String updateUserByName(int userId, String userName) {
        return userDAO.updateUserByName(userId, userName);
    }

    @Override
    @Transactional
    public String updateUserByPassword(int userId, String userPassword) {
        return userDAO.updateUserByName(userId, userPassword);
    }

}
