package com.spring.series.jdbc.model;

import java.sql.Timestamp;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private Timestamp timestamp;

	private int userToCategoryCategoryCategoryId ;
	private int userToCategoryCategoryId;


	public User() {

	}

	public User(int id, String name, String email, String password, Timestamp timestamp, int userToCategoryCategoryCategoryId, int userToCategoryCategoryId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.timestamp = timestamp;
		this.userToCategoryCategoryCategoryId = userToCategoryCategoryCategoryId;
		this.userToCategoryCategoryId = userToCategoryCategoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getUserToCategoryCategoryCategoryId() {
		return userToCategoryCategoryCategoryId;
	}

	public void setUserToCategoryCategoryCategoryId(int userToCategoryCategoryCategoryId) {
		this.userToCategoryCategoryCategoryId = userToCategoryCategoryCategoryId;
	}

	public int getUserToCategoryCategoryId() {
		return userToCategoryCategoryId;
	}

	public void setUserToCategoryCategoryId(int userToCategoryCategoryId) {
		this.userToCategoryCategoryId = userToCategoryCategoryId;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", timestamp=" + timestamp +
				", userToCategoryCategoryCategoryId=" + userToCategoryCategoryCategoryId +
				", userToCategoryCategoryId=" + userToCategoryCategoryId +
				'}';
	}
}