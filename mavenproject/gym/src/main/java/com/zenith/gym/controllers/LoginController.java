package com.zenith.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	@GetMapping("/login")
	public String index() {
		return "/login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "/dashboard";
	}
	
}
