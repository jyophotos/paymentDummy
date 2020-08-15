package com.dummy.paymentdummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_details")
public class LoginDetails {

	@Id
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "user_id", nullable = false)
	private int user_id;
	
	@Column(name = "failed_attempt", nullable = false)
	private int failed_attempt;
	
	@Column(name = "status", nullable = false)
	private int status;

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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFailed_attempt() {
		return failed_attempt;
	}

	public void setFailed_attempt(int failed_attempt) {
		this.failed_attempt = failed_attempt;
	}

	public int isStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LoginDetails() {
		
	}

	public LoginDetails(String username, String password, int user_id, int failed_attempt, int status) {
		this.username = username;
		this.password = password;
		this.user_id = user_id;
		this.failed_attempt = failed_attempt;
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginDetails [username=" + username + ", password=" + password + ", user_id=" + user_id
				+ ", failed_attempt=" + failed_attempt + ", status=" + status + "]";
	}
	
}
