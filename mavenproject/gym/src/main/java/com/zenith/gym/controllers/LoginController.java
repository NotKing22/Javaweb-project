package com.zenith.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	@GetMapping("/login")
	public String index(Model model) {
		model.addAttribute("Mensal", null);
		model.addAttribute("Trimestral", null);
		model.addAttribute("Semestral", null);
		model.addAttribute("Anual", null);
		return "/login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "/dashboard";
	}
	
}
