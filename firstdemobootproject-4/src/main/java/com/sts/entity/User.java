package com.sts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Signin_Users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private long id;
 @Column(name="usernames")
 private String username;
 @Column(name="password")
 private String password;
 @Column(name="condition_agreed")
 private boolean agreeme;


 public User() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", agreeme=" + agreeme + "]";
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
public boolean getAgreeme() {
	return agreeme;
}
public void setAgreeme(boolean agreeme) {
	this.agreeme = agreeme;
}
}