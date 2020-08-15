package com.chatbot.chatbot;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="login")
public class Login {
	private String username,password;
	public Login() {
		
	}
	public Login(String username,String password) {
		this.username=username;
		this.password=password;
	}
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
}