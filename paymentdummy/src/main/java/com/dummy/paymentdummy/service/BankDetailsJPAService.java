package com.dummy.paymentdummy.service;

import com.dummy.paymentdummy.entity.BankDetails;

public interface BankDetailsJPAService {

	public BankDetails addBankDetails(BankDetails bankDetails);
	
	public BankDetails getBankDetails(BankDetails bankDetails);
}
