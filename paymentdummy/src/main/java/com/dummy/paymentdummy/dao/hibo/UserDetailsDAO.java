package com.dummy.paymentdummy.dao.hibo;

import java.util.List;

import com.dummy.paymentdummy.entity.UserDetails;

public interface UserDetailsDAO {

	public List<UserDetails> getAllUsers();
	
	public void addUser(UserDetails userDetails);
	
	public List<UserDetails> getUser(String key, String value);
	
	public void updateUser(UserDetails userDetails);
	
}
