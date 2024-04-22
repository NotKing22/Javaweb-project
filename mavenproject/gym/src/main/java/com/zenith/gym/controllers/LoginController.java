package com.zenith.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	
	@GetMapping("/login")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("Mensal", null);
		model.addAttribute("Trimestral", null);
		model.addAttribute("Semestral", null);
		model.addAttribute("Anual", null);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "/login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "/dashboard";
	}
	
}
