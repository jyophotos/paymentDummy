package com.dummy.paymentdummy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dummy.paymentdummy.dao.BankDetailsRepository;
import com.dummy.paymentdummy.dao.UserDetailsRepository;
import com.dummy.paymentdummy.entity.BankDetails;
import com.dummy.paymentdummy.entity.UserDetails;
import com.dummy.paymentdummy.service.BankDetailsJPAService;

@Service
@Transactional
public class BankDetailsJPAServiceImpl implements BankDetailsJPAService {

	BankDetailsRepository bankDetailsRepository;
	UserDetailsRepository userDetailsRepository;
	
	public BankDetailsJPAServiceImpl(BankDetailsRepository bankDetailsRepository, UserDetailsRepository userDetailsRepository) {
		this.bankDetailsRepository=bankDetailsRepository;
		this.userDetailsRepository=userDetailsRepository;
	}
	
	@Override
	public BankDetails addBankDetails(BankDetails bankDetails) {
		if(bankDetails.getUserDetails()!= null && bankDetails.getUserDetails().getUsername() != null) {
			UserDetails userDetail = bankDetails.getUserDetails();
			List<UserDetails> userList = userDetailsRepository.getUserByUsername(userDetail.getUsername());
			if (userList == null || userList.isEmpty()) {
				throw new RuntimeException("Username not found");
			} else if (userList.get(0).isStatus()) {
				if(userList.get(0).getBankDetails() == null) {
					bankDetails.setUserDetails(userList.get(0));
					BankDetails dbBankDetails = null;
					dbBankDetails = bankDetailsRepository.save(bankDetails);
					return dbBankDetails;
				}else {
					throw new RuntimeException("User Has already one account linked");
				}
				
			} else {
				throw new RuntimeException("Account is Locked !!!");
			}
		}
		return null;
	}
	
	@Override
	public BankDetails getBankDetails(BankDetails bankDetails) {
		Optional<BankDetails> dbBankDetails = bankDetailsRepository.findById(bankDetails.getAccountNumber());
		if(dbBankDetails.isPresent()){
			return dbBankDetails.get();
		}
		return null;
	}

}
