package com.dummy.paymentdummy.service;

import java.util.List;

import com.dummy.paymentdummy.entity.UserDetails;

public interface UserDetailsJPAService {

	public List<UserDetails> getUser(String key, String value);

	public String loginUser(UserDetails userDetails);

	public String unlockAccount(UserDetails userDetails);

	public UserDetails addUser(UserDetails userDetails);
	
	public List<UserDetails> getAllUsers();
}
