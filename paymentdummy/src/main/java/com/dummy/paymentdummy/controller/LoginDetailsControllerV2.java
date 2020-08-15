package com.dummy.paymentdummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.paymentdummy.entity.UserDetails;
import com.dummy.paymentdummy.service.UserDetailsJPAService;

@RestController
@RequestMapping("/api/v2")
public class LoginDetailsControllerV2 {

	UserDetailsJPAService userDetailsJPAService;
	
	@Autowired
	public LoginDetailsControllerV2(UserDetailsJPAService userDetailsJPAService) {
		this.userDetailsJPAService=userDetailsJPAService;
	}
	
	@PostMapping("/login-user")
	public String loginUser(@RequestBody UserDetails userDetails) {
		return this.userDetailsJPAService.loginUser(userDetails);
	}
	
	@PostMapping("/unlock-user")
	public String unlockUser(@RequestBody UserDetails userDetails) {
		return this.userDetailsJPAService.unlockAccount(userDetails);
	}
}
