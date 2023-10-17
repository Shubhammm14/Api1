package com.sts.entity;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class SigninData {
    @NotBlank()
    @Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="invalid E-mail type")
	private String username;
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="contain atleast 8 charachters,atleast one uppercase,one lowercase,one digit and one special charcter")
	private String password;
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="contain atleast 8 charachters,atleast one uppercase,one lowercase,one digit and one special charcter")
	private String rPassword;
    @AssertTrue
	private boolean agreeMe;
	@Override
	public String toString() {
		return "SigninData [username=" + username + ", password=" + password + ", rPassword=" + rPassword + ", areeMe="
				+ agreeMe + "]";
	}
	public SigninData() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getrPassword() {
		return rPassword;
	}
	public void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}
	public boolean isAgreeMe() {
		return agreeMe;
	}
	public void setAgreeMe(boolean agreeMe) {
		this.agreeMe = agreeMe;
	}

}
