package com.zenith.gym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zenith.gym.logins.Login_db;
import com.zenith.gym.models.UserModel;
import com.zenith.gym.models.repositories.LoginRepository;


@Controller
public class LoginController {

	@Autowired
	private LoginRepository loginRep;
	
	@GetMapping("/login")
	public String index() {
		return "/login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "/dashboard";
	}
	
	/*@PostMapping("/logar")
	public String logar(Model model, UserModel param, Login_db login) {
		
		Login_db user = loginRep.login(login.getEmail(), login.getSenha());
		
		if (user != null) {
			String[] nome = param.getNome_completo().split(" ");
			model.addAttribute("username", nome[0]);
			System.out.println("nome " + nome[0] + " " + param.getNome_completo());
			return "/entrar";
		}
		model.addAttribute("errologin", "Usuário ou senha inválidos.");
		return "redirect:/login";
	}*/
	
}
