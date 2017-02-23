package com.spring.series.jdbc.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.series.jdbc.dao.UserDAO;
import com.spring.series.jdbc.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static String userDB = readProperty("username");
	private static String passwordDB = readProperty("password");
	private static String url = readProperty("url");

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public User getUser(int userId) {
		User user = new User();

		try {
			con = DriverManager.getConnection(url, userDB, passwordDB);
			pstmt = con.prepareStatement(sqlGetById);
			pstmt.setInt(1, userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				user = getUserFromResultSet(rs);
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try { con.close(); } catch(SQLException se) {  }
			try { pstmt.close(); } catch(SQLException se) {  }
			try { rs.close(); } catch(SQLException se) {  }
		}

		return user;
	}

	@Override
	public String insertNewUser(User user) {

		int returnValue = getJdbcTemplate().update(
				sqlInsertUser,
				new Object[] { user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getUserToCategoryCategoryId(),
				user.getUserToCategoryCategoryCategoryId()});
		if(1 == returnValue)
			return "User creation is SUCCESS";
		else
			return "User creation is FAILURE";
	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = new LinkedList<>();

		try {
			con = DriverManager.getConnection(url, userDB, passwordDB);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlGetAll);

			while (rs.next()) {
				User user = getUserFromResultSet(rs);
				users.add(user);
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try { con.close(); } catch(SQLException se) {  }
			try { stmt.close(); } catch(SQLException se) {  }
			try { rs.close(); } catch(SQLException se) {  }
		}

		return users;
	}

	private User getUserFromResultSet (ResultSet rs) {
		User user = new User();
		try {

			user.setId(rs.getInt("user_id"));
			user.setName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setUserToCategoryCategoryCategoryId(rs.getInt("user_to_category_category_category_id"));
			user.setUserToCategoryCategoryId(rs.getInt("user_to_category_category_id"));
			user.setTimestamp(rs.getTimestamp("create_time"));
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

		return user;

	}

	private static String readProperty(String key) {
		FileInputStream fis;
		Properties property = new Properties();

		try {
			fis = new FileInputStream("src/main/resources/com/spring/series/jdbc/jdbc.properties");
			property.load(fis);

			return property.getProperty(key);


		} catch (IOException e) {
			System.err.println("ОШИБКА: Файл свойств отсуствует!");
		}

		return "";
	}

}