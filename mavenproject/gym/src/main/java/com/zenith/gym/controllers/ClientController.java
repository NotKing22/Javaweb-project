package com.zenith.gym.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zenith.gym.logins.Admin_db;
import com.zenith.gym.logins.Login_db;
import com.zenith.gym.models.AdminModel;
import com.zenith.gym.models.UserModel;
import com.zenith.gym.models.UserPlans;
import com.zenith.gym.models.repositories.LoginRepository;
import com.zenith.gym.models.repositories.PlansRepository;
import com.zenith.gym.models.repositories.RegistrationsRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ClientController {

	@Autowired
	private RegistrationsRepository registrationRepo;
	@Autowired
	private PlansRepository plansRepo;
	@Autowired
	private LoginRepository loginRepo;
	
	@GetMapping("/administradores/clientes")
	public String index(Model model) {
		List<UserModel> clientes = (List<UserModel>) registrationRepo.findAll();
		model.addAttribute("clientes", clientes);
		return "administradores/clientes";
	}
	
	
	@GetMapping("/administradores/clientes/{id}/excluir")
	public String excluir(@PathVariable("id") int id) {
		Optional<UserModel> registerInfo = registrationRepo.findById(id);
		if (registerInfo.isPresent()) {
			int matriculaID = registerInfo.get().getMatricula();
			loginRepo.deleteById(matriculaID);
		}
		registrationRepo.deleteById(id);
		plansRepo.deleteById(id);
		return "redirect:/administradores/clientes";
	}
	
	@GetMapping("/administradores/clientes/{id}/editar")
	public String alterar(@PathVariable("id") int id, UserModel info, Login_db login, Model model) {
		
		Optional<UserModel> registerInfo = registrationRepo.findById(id);
		Optional<UserPlans> plansInfo = plansRepo.findById(id);
		
		//plans nome email plano_academia
		//registerInfo rg nomecompleto, datanascimento, sexo, endereco, planoacademia, statusacademia
		if (registerInfo.isPresent() && plansInfo.isPresent()) {
			System.out.println("run");
			model.addAttribute("id", registerInfo.get().getID());
			
		    model.addAttribute("rg", registerInfo.get().getRG());
		    model.addAttribute("nome", registerInfo.get().getNome_completo());
		    model.addAttribute("endereco", registerInfo.get().getEndereço());
		    
		    model.addAttribute("datanascimento", registerInfo.get().getData_nascimento());
		    model.addAttribute("sexo", registerInfo.get().getSexo());
		    model.addAttribute("planoacademia", registerInfo.get().getPlano_academia());
		    model.addAttribute("statusacademia", registerInfo.get().getStatus_academia());
		    
		    model.addAttribute("email", login.getEmail()); //nao esta sendo passado
		    model.addAttribute("senha", login.getSenha()); //nao esta sendo passado
		    model.addAttribute("matricula", login.getMatricula()); //nao esta sendo passado
		    
		}
	    return "administradores/clientes/alterar";
	}
	
	@PostMapping("/administradores/clientes/salvar")
	public String update(HttpServletRequest request, Login_db login, UserModel info) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String matricula = request.getParameter("matricula");
		String email = request.getParameter("email");
		
			loginRepo.updateLogin(id, email, login.getSenha()); //email e ID sao inalteraveis, por isso so pega a senha do form.
			registrationRepo.updateUsuario(matricula, info.getRG(), info.getNome_completo(), 
					info.getData_nascimento(), info.getSexo(), info.getEndereço(), info.getPlano_academia(), info.getStatus_academia());
			plansRepo.updateUsuario(login.getMatricula(), info.getRG(), info.getNome_completo(), email, info.getPlano_academia());
			
			//registrationRepo.updateUser(ID, info.getRG(), info.getNome(), info.getEndereço(), salario);
			//ao copiar o de cima mude os param
			
			//criar update no plansRepo e RegistrationRepo.
			
			return "redirect:/administradores/clientes";
		}
	
}
