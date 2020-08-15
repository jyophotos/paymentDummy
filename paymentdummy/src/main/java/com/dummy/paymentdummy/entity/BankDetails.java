package com.dummy.paymentdummy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bank_details")
public class BankDetails {

	@Id
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "name")
	private String bankName;
	
	/*
	 * @Column(name = "user_id") private int userId;
	 */
	
	@OneToOne /* (cascade = CascadeType.ALL) */
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private UserDetails userDetails;
	
	public BankDetails() {
		
	}

	public BankDetails(String accountNumber, String bankName) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", bankName=" + bankName + ", userDetails=" + userDetails
				+ "]";
	}
	
	@OneToMany(mappedBy = "bankDetails")
	private List<TransactionDetails> transactionDetails;

	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	
}
