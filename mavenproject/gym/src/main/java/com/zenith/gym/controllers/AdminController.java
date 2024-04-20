package com.zenith.gym.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zenith.gym.logins.Admin_db;
import com.zenith.gym.models.AdminModel;
import com.zenith.gym.models.repositories.AdminRepository;
import com.zenith.gym.models.repositories.LoginAdmRepository;
import com.zenith.gym.models.repositories.PlansRepository;
import com.zenith.gym.models.repositories.RegistrationsRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepo; 
	@Autowired
	private LoginAdmRepository loginAdmRepo;
	@Autowired
	private RegistrationsRepository RegistrationRepo;
	@Autowired
	private PlansRepository plansRepo;
	
	int salario = 5000;
	
	@GetMapping("/administradores/ver")
	public String index(Model model, HttpServletRequest request) {
	//	HttpSession session = request.getSession(false);
	
		//session off durante periodo de desenvolvimento, para nao atrapalhar.
		
	//	if (session != null && session.getAttribute("usuarioAdmin") != null) {
		
			List<AdminModel> administradores = (List<AdminModel>) adminRepo.findAll();
			model.addAttribute("administradores", administradores); //nome da table
			return "administradores/ver";
	//	}
	//	return "redirect:/login";
	}
	
	@GetMapping("/administradores/novo")
	public String novo() {
			return "administradores/novo";
		}
	
	@PostMapping("/administradores/criar")
	public String criar(Admin_db login, AdminModel info) {
			loginAdmRepo.save(login);
			adminRepo.cadastrarAdm(info.getRG(), info.getNome(), info.getEndereço(), salario);
			
			return "redirect:/administradores/ver";
		}
	
	@GetMapping("/administradores/{id}/excluir")
	public String excluir(@PathVariable("id") int id) {
		loginAdmRepo.deleteById(id);
		adminRepo.deleteById(id);
		
		return "redirect:/administradores/ver";
	}
	
	@GetMapping("/administradores/{id}/editar")
	public String alterar(@PathVariable("id") int id, AdminModel info, Model model) {
		
		Optional<AdminModel> adminInfos = adminRepo.findById(id);
		Optional<Admin_db> adminLogins = loginAdmRepo.findById(id);
		System.out.println("DEBUG " + adminInfos.isPresent() + " " + adminLogins.isPresent());
		if (adminInfos.isPresent() && adminLogins.isPresent()) {
			model.addAttribute("id", adminInfos.get().getID());
			
		    model.addAttribute("rg", adminInfos.get().getRG());
		    model.addAttribute("nome", adminInfos.get().getNome());
		    model.addAttribute("endereço", adminInfos.get().getEndereço());
		    
		    model.addAttribute("email", adminLogins.get().getEmail());
		    model.addAttribute("senha", adminLogins.get().getSenha()); 
		}
	    return "administradores/alterar";
	}
	
	@PostMapping("/administradores/salvar")
	public String update(HttpServletRequest request, Admin_db login, AdminModel info) {
		Integer ID = Integer.parseInt(request.getParameter("id"));
		
			loginAdmRepo.updateLogin(ID, login.getEmail(), login.getSenha());
			adminRepo.updateAdm(ID, info.getRG(), info.getNome(), info.getEndereço(), salario);
			
			return "redirect:/administradores/ver";
		}

	
	@GetMapping("/administradores/dashboard")
	public String dashboard() {
			return "administradores/dashboard";
		}
	
	}
