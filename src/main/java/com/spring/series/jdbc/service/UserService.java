package com.spring.series.jdbc.service;

import com.spring.series.jdbc.model.User;

import java.util.List;

public interface UserService {
    User getUser(int userId);
    String insertNewUser(User user);
    List<User> getAllUsers();
}