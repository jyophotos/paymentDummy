package com.dummy.paymentdummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "failed_attempt")
	private int failed_attampt;
	
	@Column(name = "status")
	private boolean status;

	public UserDetails(String name, String address, String emailId, String phoneNumber, String username,
			String password, int failed_attampt, boolean status) {
		super();
		this.name = name;
		this.address = address;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.failed_attampt = failed_attampt;
		this.status = status;
	}

	public UserDetails() {
		super();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public int getFailed_attampt() {
		return failed_attampt;
	}

	public void setFailed_attampt(int failed_attampt) {
		this.failed_attampt = failed_attampt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", address=" + address + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", username=" + username + ", password=" + password
				+ ", failed_attampt=" + failed_attampt + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@OneToOne(mappedBy = "userDetails" /* , cascade = CascadeType.ALL */)
	@JsonBackReference
	private BankDetails bankDetails;

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	
}
