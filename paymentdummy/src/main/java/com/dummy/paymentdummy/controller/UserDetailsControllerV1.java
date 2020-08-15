package com.dummy.paymentdummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.paymentdummy.entity.UserDetails;
import com.dummy.paymentdummy.service.hibo.UserDetailsService;

@RestController
@RequestMapping("/api/v1")
public class UserDetailsControllerV1 {

	UserDetailsService userDetailsService;
	
	@Autowired
	public UserDetailsControllerV1(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	/* @GetMapping("/users") */
	public List<UserDetails> getAllUsers(){
		return userDetailsService.getAllUsers();
	}
	
	/* @PostMapping("/add-user") */
	public UserDetails addUser(@RequestBody UserDetails userDetails) {
		return userDetailsService.addUser(userDetails);
	}
}
