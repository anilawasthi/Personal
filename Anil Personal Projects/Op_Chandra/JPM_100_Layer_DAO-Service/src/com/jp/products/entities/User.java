package com.jp.products.entities;

public class User {
	private int userId;
	private String userName;
	private String pass;
	private String role;

	public User(int userId, String userName, String pass, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pass = pass;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", pass=" + pass + ", role=" + role + "]";
	}
}
