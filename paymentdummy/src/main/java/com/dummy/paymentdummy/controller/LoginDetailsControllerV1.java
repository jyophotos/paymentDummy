package com.dummy.paymentdummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.paymentdummy.entity.UserDetails;
import com.dummy.paymentdummy.service.hibo.UserDetailsService;

@RestController
@RequestMapping("/api/v1")
public class LoginDetailsControllerV1 {

	UserDetailsService userDetailsService;
	
	@Autowired
	public LoginDetailsControllerV1(UserDetailsService userDetailsService) {
		this.userDetailsService=userDetailsService;
	}
	
	/* @PostMapping("/login-user") */
	public String loginUser(@RequestBody UserDetails userDetails) {
		return this.userDetailsService.loginUser(userDetails);
	}
	
	/* @PostMapping("/unlock-user") */
	public String unlockUser(@RequestBody UserDetails userDetails) {
		return this.userDetailsService.unlockAccount(userDetails);
	}
}
