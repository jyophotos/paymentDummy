package com.dummy.paymentdummy.service.hibo;

import java.util.List;

import com.dummy.paymentdummy.entity.UserDetails;

public interface UserDetailsService {

	public List<UserDetails> getAllUsers();
	
	public UserDetails addUser(UserDetails userDetails);
	
	public String loginUser(UserDetails userDetails);
	
	public String unlockAccount(UserDetails userDetails);
}
