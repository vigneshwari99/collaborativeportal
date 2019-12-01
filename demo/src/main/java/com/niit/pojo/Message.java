package com.niit.pojo;

public class Message {
	private String message;
	private int id;
	private int userId;
	private String username;

	public Message() {

	}

	public Message(int id, String message, int userId, String username) {
		this.id = id;
		this.message = message;
		this.userId = userId;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
