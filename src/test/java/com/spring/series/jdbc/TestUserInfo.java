package com.spring.series.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.series.jdbc.dao.UserDAO;
import com.spring.series.jdbc.model.User;

public class TestUserInfo {

	public static void main(String[] args) {
		testSpringJdbcTemplate();
	}

	private static void testSpringJdbcTemplate(){

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/spring/series/jdbc/SpringContext.xml");
		UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");


		User user = userDAO.getUser(1);

		System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getPassword() + "\t"
				+ user.getEmail());

		User newUser = new User(11, "Vasya", "vasya@gmail.com", "111111", new Timestamp(System.currentTimeMillis()),
				1,1);

		String returnStr = userDAO.insertNewUser(newUser);
		System.out.println("Return message : " + returnStr);

		returnStr = userDAO.updateUserByName(11, "Kolya");
		System.out.println("Return message : " + returnStr);

		returnStr = userDAO.updateUserByPassword(11, "new password");
		System.out.println("Return message : " + returnStr);

		List<User> users = userDAO.getAllUsers();

		for(User userDB : users){
			System.out.println(userDB.getId() + "\t" + userDB.getName() + "\t" + userDB.getPassword() + "\t" + userDB.getEmail());
		}
	}
}