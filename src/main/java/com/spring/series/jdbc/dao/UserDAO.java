package com.spring.series.jdbc.dao;

import java.util.List;

import com.spring.series.jdbc.model.User;

public interface UserDAO {

	String sqlGetById = "SELECT * FROM user WHERE user_id = ?";
	String sqlGetAll = "SELECT * FROM user";
	String sqlInsertUser = "INSERT INTO User(user_id, username, email, password, user_to_category_category_id, " +
			"user_to_category_category_category_id)" +
			" VALUES(?, ?, ?, ?, ?, ?)";
	String sqlUpdateUserByName = "UPDATE user SET username = ? WHERE user_id = ?";
	String sqlUpdateUserByPassword = "UPDATE user SET password = ? WHERE user_id = ?";

	User getUser(int userId);
	String insertNewUser(User user);
	List<User> getAllUsers();
	String updateUserByName(int userId, String userName);
	String updateUserByPassword(int userId, String password);
}