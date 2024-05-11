package com.zenith.gym.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zenith.gym.logins.Login_db;
import com.zenith.gym.models.UserModel;
import com.zenith.gym.models.UserPlans;
import com.zenith.gym.services.ClientServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
	
	@Autowired
	ClientServices servicesClient;
	
	@GetMapping("/administradores/clientes")
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
			List<UserModel> clientes = (List<UserModel>) servicesClient.findAllRegistrationRepo();
			model.addAttribute("clientes", clientes);
			return "administradores/clientes";
		}
		return "redirect:/login";
	}
	
	
	@GetMapping("/administradores/clientes/{id}/excluir")
	public String excluir(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
		
			Optional<UserModel> registerInfo = servicesClient.findByIDregistrationRepo(id);
		
		if (registerInfo.isPresent()) {
			int matriculaID = registerInfo.get().getMatricula();
			servicesClient.deleteByIDlogin(matriculaID);
		}
			servicesClient.deleteByIDregistrationRepo(id);
			servicesClient.deleteByIDplans(id);
			return "redirect:/administradores/clientes";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/administradores/clientes/{id}/editar")
	public String alterar(@PathVariable("id") int id, UserModel info, Login_db login, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
		
			Optional<UserModel> registerInfo = servicesClient.findByIDregistrationRepo(id);
			Optional<UserPlans> plansInfo = servicesClient.findByIDplans(id);
			Optional<Login_db> loginInfo = servicesClient.findByIDlogin(registerInfo.get().getMatricula());
			
			if (registerInfo.isPresent() && plansInfo.isPresent() && loginInfo.isPresent()) {
				model.addAttribute("id", registerInfo.get().getID());
				
			    model.addAttribute("rg", registerInfo.get().getRG());
			    model.addAttribute("nome", registerInfo.get().getNome_completo());
			    model.addAttribute("endereco", registerInfo.get().getEndereço());
			    
			    model.addAttribute("datanascimento", registerInfo.get().getData_nascimento());
			    model.addAttribute("sexo", registerInfo.get().getSexo());
			    model.addAttribute("planoacademia", registerInfo.get().getPlano_academia());
			    model.addAttribute("statusacademia", registerInfo.get().getStatus_academia());
			    
			    model.addAttribute("email", loginInfo.get().getEmail()); 
			    model.addAttribute("senha", loginInfo.get().getSenha()); 
			    model.addAttribute("matricula", loginInfo.get().getMatricula()); 
			    
			}
		    return "administradores/clientes/alterar";
			}
			return "redirect:/login";
		}
	
	@PostMapping("/administradores/clientes/salvar")
	public String update(HttpServletRequest request, Login_db login, UserModel info) {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("usuarioAdmin") != null) {
			
			final Integer id = Integer.parseInt(request.getParameter("id"));
			final String matricula = request.getParameter("matricula");
			final String email = request.getParameter("email");
			
				servicesClient.updateLogin(Integer.parseInt(matricula), email, login.getSenha()); //email e ID sao inalteraveis, por isso so pega a senha do form.
				
				servicesClient.updateUsuario
				    (matricula, 
					info.getRG(), 
					info.getNome_completo(), 
					info.getData_nascimento(), 
					info.getSexo(), info.getEndereço(), 
					info.getPlano_academia(), 
					info.getStatus_academia(), id);
				servicesClient.updatePlans
				   (login.getMatricula(),
					info.getRG(), 
					info.getNome_completo(),
					email, 
					info.getPlano_academia());
	
				return "redirect:/administradores/clientes";
				}
			return "redirect:/login";
		}
	
}
