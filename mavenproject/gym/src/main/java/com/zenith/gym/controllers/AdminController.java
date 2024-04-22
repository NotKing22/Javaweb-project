package com.zenith.gym.controllers;

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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepo; 
	@Autowired
	private LoginAdmRepository loginAdmRepo;
	
	int salario = 5000;
	
	@GetMapping("/administradores/ver")
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
	
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
		
			List<AdminModel> administradores = (List<AdminModel>) adminRepo.findAll();
			model.addAttribute("administradores", administradores); //nome da table
			return "administradores/ver";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/administradores/novo")
	public String novo(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
			return "administradores/novo";
		}
		return "redirect:/login";
	}
	
	@PostMapping("/administradores/criar")
	public String criar(Admin_db login, AdminModel info, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
			loginAdmRepo.save(login);
			adminRepo.cadastrarAdm(info.getRG(), info.getNome(), info.getEndereço(), salario);
			
			return "redirect:/administradores/ver";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/administradores/{id}/excluir")
	public String excluir(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
		loginAdmRepo.deleteById(id);
		adminRepo.deleteById(id);
		
		return "redirect:/administradores/ver";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/administradores/{id}/editar")
	public String alterar(@PathVariable("id") int id, AdminModel info, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
		
		Optional<AdminModel> adminInfos = adminRepo.findById(id);
		Optional<Admin_db> adminLogins = loginAdmRepo.findById(id);
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
		return "redirect:/login";
	}
	
	@PostMapping("/administradores/salvar")
	public String update(HttpServletRequest request, Admin_db login, AdminModel info) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
		Integer ID = Integer.parseInt(request.getParameter("id"));
		
			loginAdmRepo.updateLogin(ID, login.getEmail(), login.getSenha());
			adminRepo.updateAdm(ID, info.getRG(), info.getNome(), info.getEndereço(), salario);
			
			return "redirect:/administradores/ver";
		}
		return "redirect:/login";
	}

	
	@GetMapping("/administradores/dashboard")
	public String dashboard(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
			return "administradores/dashboard";
			}
		return "redirect:/login";
		}
	
	}
