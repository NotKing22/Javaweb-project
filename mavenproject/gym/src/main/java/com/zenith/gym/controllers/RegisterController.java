package com.zenith.gym.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zenith.gym.logins.Admin_db;
import com.zenith.gym.logins.Login_db;
import com.zenith.gym.models.UserModel;
import com.zenith.gym.models.UserPlans;
import com.zenith.gym.models.repositories.LoginAdmRepository;
import com.zenith.gym.models.repositories.LoginRepository;
import com.zenith.gym.models.repositories.PlansRepository;
import com.zenith.gym.models.repositories.RegistrationsRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {
    
    @Autowired
    private RegistrationsRepository repositorySQL;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PlansRepository plansRepository;
    @Autowired
    private LoginAdmRepository LoginAdmRepository;
    
    @GetMapping("/formulario-cadastro")
    public String usuarioCadastro() {
        return "usercadastro"; // Retorna a página de cadastro
    }
    
    @PostMapping("/entrar")
    public String logou(@ModelAttribute Login_db login, HttpSession session, Model model) {
    	System.out.println("Iniciando método logou...");
    	System.out.println("login " + login.getEmail() + " senha " + login.getSenha());
    	
        boolean credenciaisCorretas = validarCredenciais(login.getEmail(), login.getSenha());
        
        boolean admin = false;
        if (credenciaisCorretas) {
            session.setAttribute("usuarioAutenticado", true);
            
            if (isAdmin(login.getEmail(), login.getSenha())) {
            	session.setAttribute("usuarioAdmin", true);
            	model.addAttribute("mensal", true);
            	model.addAttribute("trimensal", true);
            	model.addAttribute("semestral", true);
            	model.addAttribute("anual", true);
            	model.addAttribute("is_admin", true);
            	model.addAttribute("nome", "Administrador");
            	admin = true;
            	System.out.println("usuario reconhecido como administrador.");
            }
            
            if (admin == false) {
	            switch(plansRepository.findPlanoByEmail(login.getEmail())){
		        	case "Mensal":
		        		model.addAttribute("mensal", true);
		        		break;
		        	case "Trimensal":
		        		model.addAttribute("trimensal", true);
		        		break;
		        	case "Semestral":
		        		model.addAttribute("semestral", true);
		        		break;
		        	case "Anual":
		        		model.addAttribute("anual", true);
		        		break;
	        		default:
	        			model.addAttribute("sem_plano", true);
	            }
	            String[] nome_completo = plansRepository.findNameByEmail(login.getEmail()).split(" ");
	            String primeiro_nome = nome_completo[0];
	            model.addAttribute("nome", primeiro_nome);
            }
            return "entrar";
        } else {
        	System.out.println("recusado");
            model.addAttribute("erroLogin", "* Credenciais inválidas. Por favor, tente novamente.");
            return "login";
        }
    }

    private boolean validarCredenciais(String email, String senha) {
        Login_db user = loginRepository.findByEmailAndSenha(email, senha);
        return user != null;
    }
    
    private boolean isAdmin(String email, String senha) {
        Admin_db user = LoginAdmRepository.findByEmailAndSenha(email, senha);
        return user != null;
    }
    
    @Transactional
    @PostMapping("/cadastrar")
    public String cadastro(Model model, UserModel userModel, Login_db login, UserPlans plans, RedirectAttributes redirectAttributes) {
    	if (!loginRepository.existsByEmail(login.getEmail())) {
    		userModel.setStatus_academia("Ativo");
    		String data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyddMM"));
    		
	    	repositorySQL.save(userModel);
	    	
	    	userModel.setMatricula(Integer.parseInt(data + userModel.getID())); 
	    	
	    	repositorySQL.save(userModel);
	    	
	    	loginRepository.cadastrarLogin(userModel.getMatricula(), 
							    			login.getEmail(),
							    			login.getSenha());

	    	plansRepository.cadastrarPlano(userModel.getMatricula(), 
						    			userModel.getRG(), 
						    			userModel.getNome_completo(), 
						    			login.getEmail(), 
						    			userModel.getPlano_academia());
	    	return "redirect:/login"; 
    	} else {
    		redirectAttributes.addFlashAttribute("erroEmail", "* E-mail já cadastrado. Por favor, autentique-se.");
    		return "redirect:/formulario-cadastro";
    	}
    }
    
}
