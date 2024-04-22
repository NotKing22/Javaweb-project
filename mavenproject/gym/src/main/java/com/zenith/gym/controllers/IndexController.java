package com.zenith.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/modalidades")
	public String modalidades() {
		return "/modalidades";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "/contato";
	}
	
}
