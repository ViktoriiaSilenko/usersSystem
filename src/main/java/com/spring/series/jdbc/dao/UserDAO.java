package com.spring.series.jdbc.dao;

import java.util.List;

import com.spring.series.jdbc.model.User;

public interface UserDAO {

	String sqlGetById = "SELECT * FROM user WHERE user_id = ?";
	String sqlGetAll = "SELECT * FROM user";

	String url = "jdbc:mysql://localhost:3306/mydb";
	String userDB = "root";
	String passwordDB = "123456";

	User getUser(int userId);
	String insertNewUser(User user);
	List<User> getAllUsers();
}