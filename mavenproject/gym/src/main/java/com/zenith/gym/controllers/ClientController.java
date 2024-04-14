package com.zenith.gym.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zenith.gym.models.UserModel;
import com.zenith.gym.models.repositories.RegistrationsRepository;

@Controller
public class ClientController {

	@Autowired
	private RegistrationsRepository registrationRepo;
	
	@GetMapping("/administradores/clientes")
	public String index(Model model) {
		List<UserModel> clientes = (List<UserModel>) registrationRepo.findAll();
		model.addAttribute("clientes", clientes);
		return "administradores/clientes";
	}
	
}
