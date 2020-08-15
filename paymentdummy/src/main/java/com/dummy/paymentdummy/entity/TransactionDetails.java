package com.dummy.paymentdummy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int id;
	
	/*
	 * @Column(name = "account_number") private String accountNumber;
	 */
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "from_account_number")
	private String fromAccountNumber;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "transaction_date")
	private Date date;

	public TransactionDetails() {
		super();
	}

	public TransactionDetails(String accountNumber, double amount, /* String fromAccountNumber, */ String comment,
			Date date) {
		super();
		/* this.accountNumber = accountNumber; */
		this.amount = amount;
		this.fromAccountNumber = fromAccountNumber;
		this.comment = comment;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public String getAccountNumber() { return accountNumber; }
	 * 
	 * public void setAccountNumber(String accountNumber) { this.accountNumber =
	 * accountNumber; }
	 */
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne
	@JoinColumn(name = "account_number")
	@JsonIgnore
	private BankDetails bankDetails;

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	
}
