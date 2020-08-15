package com.dummy.paymentdummy.service.hibo.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.paymentdummy.dao.hibo.UserDetailsDAO;
import com.dummy.paymentdummy.entity.UserDetails;
import com.dummy.paymentdummy.service.hibo.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	public UserDetailsServiceImpl(UserDetailsDAO userDetailsDAO) {
		this.userDetailsDAO=userDetailsDAO;
	}
	
	@Override
	@Transactional
	public List<UserDetails> getAllUsers() {
		return userDetailsDAO.getAllUsers();
	}

	@Override
	@Transactional
	public UserDetails addUser(UserDetails userDetails) {
		userDetails.setId(0);
		userDetails.setFailed_attampt(0);
		userDetails.setStatus(true);
		List<UserDetails> userList = userDetailsDAO.getUser("username", userDetails.getUsername());
		if(userList == null || userList.isEmpty()) {
			userDetailsDAO.addUser(userDetails);
		}else {
			throw new RuntimeException("Username Already Exists");
		}
		
		return userDetails;
	}

	@Override
	@Transactional
	public String loginUser(UserDetails userDetails) {
		List<UserDetails> userList = userDetailsDAO.getUser("username", userDetails.getUsername());
		if(userList == null || userList.isEmpty()) {
			return "Username not found";
		}else if(userList.get(0).isStatus()) {
			if(userList.get(0).getPassword().equalsIgnoreCase(userDetails.getPassword())) {
				userList.get(0).setFailed_attampt(0);
				userList.get(0).setStatus(true);
				userDetailsDAO.updateUser(userList.get(0));
				/** Need to return better info */
				return userList.get(0).getName(); 
			}else {
				userList.get(0).setFailed_attampt(userList.get(0).getFailed_attampt()+1);
				if(userList.get(0).getFailed_attampt()==3) {
					userList.get(0).setStatus(false);
				}
				userDetailsDAO.updateUser(userList.get(0));
				return "Incorrect Password !!!";
			}
		}else {
			return "Account is Locked !!!";
		}
	}

	@Override
	@Transactional
	public String unlockAccount(UserDetails userDetails) {
		List<UserDetails> userList = userDetailsDAO.getUser("username", userDetails.getUsername());
		userList.get(0).setFailed_attampt(0);
		userList.get(0).setStatus(true);
		userDetailsDAO.updateUser(userList.get(0));
		return "Account Unlocked";
	}

}
