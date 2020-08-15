package com.dummy.paymentdummy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dummy.paymentdummy.entity.BankDetails;
import com.dummy.paymentdummy.service.BankDetailsJPAService;

@Controller
@RequestMapping("/api/v2")
public class BankDetailsControllerV2 {

	private BankDetailsJPAService bankDetailsJPAService;
	
	public BankDetailsControllerV2(BankDetailsJPAService bankDetailsJPAService) {
		this.bankDetailsJPAService=bankDetailsJPAService;
	}
	
	@PostMapping("/add-bank-details")
	public ResponseEntity<BankDetails> addBankDetails(@RequestBody BankDetails bankDetails) {
		BankDetails dbBankDetails = null;
		dbBankDetails = bankDetailsJPAService.addBankDetails(bankDetails);
		ResponseEntity<BankDetails> resposeEntity = new ResponseEntity<BankDetails>(dbBankDetails,HttpStatus.OK);
		return resposeEntity;
	}
	
	@PostMapping("/get-bank-details")
	public ResponseEntity<BankDetails> getBankDetails(@RequestBody BankDetails bankDetails) {
		BankDetails dbBankDetails = null;
		dbBankDetails = bankDetailsJPAService.getBankDetails(bankDetails);
		ResponseEntity<BankDetails> resposeEntity = new ResponseEntity<BankDetails>(dbBankDetails,HttpStatus.OK);
		return resposeEntity;
	}
}
