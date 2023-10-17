package com.sts.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;

//import jakarta.persistence.Entity;


public class LoginData {
	@NotBlank()
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="invalid E-mail type")
	private String username;
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="contain atleast 8 charachters,atleast one uppercase,one lowercase,one digit and one special charcter")
	private String password;
	private String rememberMe;
	
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginData [username=" + username + ", password=" + password + "]";
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
	public String getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

}
