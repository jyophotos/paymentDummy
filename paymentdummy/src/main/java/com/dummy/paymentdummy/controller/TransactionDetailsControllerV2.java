package com.dummy.paymentdummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dummy.paymentdummy.entity.BankDetails;
import com.dummy.paymentdummy.entity.TransactionDetails;
import com.dummy.paymentdummy.service.TransactionDetailsJPAService;

@Controller
@RequestMapping("/api/v2")
public class TransactionDetailsControllerV2 {

	private TransactionDetailsJPAService transactionDetailsJPAService;
	
	@Autowired
	public TransactionDetailsControllerV2(TransactionDetailsJPAService transactionDetailsJPAService) {
		this.transactionDetailsJPAService=transactionDetailsJPAService;
	}
	
	@PostMapping("/add-money")
	public ResponseEntity<TransactionDetails> addMoney(@RequestBody TransactionDetails transactionDetails) {
		TransactionDetails dbtransactionDetails = null;
		dbtransactionDetails = transactionDetailsJPAService.addMoney(transactionDetails);

		ResponseEntity<TransactionDetails> resposeEntity = new ResponseEntity<TransactionDetails>(dbtransactionDetails, HttpStatus.OK);
		return resposeEntity;

		//return dbtransactionDetails;
	}
	
	@PostMapping("/add-money/{accountNumber}")
	public ResponseEntity<TransactionDetails> addMoneyWithAccountNumber(@PathVariable("accountNumber") String accountNumber,@RequestBody TransactionDetails transactionDetails) {
		BankDetails bankDetails = new BankDetails();
		bankDetails.setAccountNumber(accountNumber);
		transactionDetails.setBankDetails(bankDetails);
		TransactionDetails dbtransactionDetails = null;
		dbtransactionDetails = transactionDetailsJPAService.addMoney(transactionDetails);
		
		ResponseEntity<TransactionDetails> resposeEntity = new ResponseEntity<TransactionDetails>(dbtransactionDetails, HttpStatus.OK);
		return resposeEntity;
		
		//return dbtransactionDetails;
	}
}
