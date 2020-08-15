package com.dummy.paymentdummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.paymentdummy.entity.UserDetails;
import com.dummy.paymentdummy.service.UserDetailsJPAService;

@RestController
@RequestMapping("/api/v2")
public class UserDetailsControllerV2 {

	UserDetailsJPAService userDetailsJPAService;
	
	@Autowired
	public UserDetailsControllerV2(UserDetailsJPAService userDetailsJPAService) {
		this.userDetailsJPAService = userDetailsJPAService;
	}
	
	@GetMapping("/users")
	public List<UserDetails> getAllUsers(){
		return userDetailsJPAService.getAllUsers();
	}
	
	@PostMapping("/add-user")
	public UserDetails addUser(@RequestBody UserDetails userDetails) {
		return userDetailsJPAService.addUser(userDetails);
	}
}
