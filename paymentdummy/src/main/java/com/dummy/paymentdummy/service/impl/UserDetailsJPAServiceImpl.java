package com.dummy.paymentdummy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.paymentdummy.dao.UserDetailsRepository;
import com.dummy.paymentdummy.entity.UserDetails;
import com.dummy.paymentdummy.service.UserDetailsJPAService;

@Service
@Transactional
public class UserDetailsJPAServiceImpl implements UserDetailsJPAService {

	UserDetailsRepository userDetailsRepository;

	@Autowired
	public UserDetailsJPAServiceImpl(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	@Override
	public List<UserDetails> getUser(String key, String value) {

		return null;
	}

	@Override
	public String loginUser(UserDetails userDetails) {
		List<UserDetails> userList = userDetailsRepository.getUserByUsername(userDetails.getUsername());
		if (userList == null || userList.isEmpty()) {
			return "Username not found";
		} else if (userList.get(0).isStatus()) {
			if (userList.get(0).getPassword().equalsIgnoreCase(userDetails.getPassword())) {
				userList.get(0).setFailed_attampt(0);
				userList.get(0).setStatus(true);
				// userDetailsRepository.updateUser(userList.get(0));
				userDetailsRepository.save(userList.get(0));
				/** Need to return better info */
				return userList.get(0).getName();
			} else {
				userList.get(0).setFailed_attampt(userList.get(0).getFailed_attampt() + 1);
				if (userList.get(0).getFailed_attampt() == 3) {
					userList.get(0).setStatus(false);
				}
				// userDetailsRepository.updateUser(userList.get(0));
				userDetailsRepository.save(userList.get(0));
				return "Incorrect Password !!!";
			}
		} else {
			return "Account is Locked !!!";
		}
	}

	@Override
	public String unlockAccount(UserDetails userDetails) {
		List<UserDetails> userList = userDetailsRepository.getUserByUsername(userDetails.getUsername());
		userList.get(0).setFailed_attampt(0);
		userList.get(0).setStatus(true);
		// userDetailsDAO.updateUser(userList.get(0));
		userDetailsRepository.save(userList.get(0));
		return "Account Unlocked";
	}

	@Override
	public UserDetails addUser(UserDetails userDetails) {
		userDetails.setId(0);
		userDetails.setFailed_attampt(0);
		userDetails.setStatus(true);
		List<UserDetails> userList = userDetailsRepository.getUserByUsername(userDetails.getUsername());
		UserDetails dbUserDetails = null;

		if (userList == null || userList.isEmpty()) {
			dbUserDetails = userDetailsRepository.save(userDetails);
		} else {
			throw new RuntimeException("Username Already Exists");
		}

		return dbUserDetails;
	}

	@Override
	public List<UserDetails> getAllUsers() {
		return userDetailsRepository.findAll();
		//return userDetailsRepository.getUserByUsername("harvey");
	}

}
