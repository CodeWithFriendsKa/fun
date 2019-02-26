package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String username;
	private String password;
	private Long token;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getToken() {
		return token;
	}
	public void setToken(Long token) {
		this.token = token;
	}
	public User(String username, String password, Long token) {
		super();
		this.username = username;
		this.password = password;
		this.token = token;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(Object user) {
		User u = (User) user;
		this.username = u.username;
		this.password = u.password;
		this.token = u.token;
	}
	public User() {
	}
	
}
