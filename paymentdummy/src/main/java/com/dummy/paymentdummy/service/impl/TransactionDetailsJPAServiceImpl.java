package com.dummy.paymentdummy.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.paymentdummy.dao.TransactionDetailsRepository;
import com.dummy.paymentdummy.entity.TransactionDetails;
import com.dummy.paymentdummy.service.TransactionDetailsJPAService;

@Service
@Transactional
public class TransactionDetailsJPAServiceImpl implements TransactionDetailsJPAService{

	private TransactionDetailsRepository transactionalDetailsRepo;
	
	@Autowired
	public TransactionDetailsJPAServiceImpl(TransactionDetailsRepository transactionalDetailsRepo) {
		this.transactionalDetailsRepo=transactionalDetailsRepo;
	}
	
	@Override
	public TransactionDetails addMoney(TransactionDetails transactionDetails) {
		return transactionalDetailsRepo.save(transactionDetails);
	}

}
