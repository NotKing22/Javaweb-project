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
import com.zenith.gym.services.LoginServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {
	
	@Autowired
	LoginServices servicesLogin;
    
    @GetMapping("/formulario-cadastro")
    public String usuarioCadastro() {
        return "usercadastro"; // Retorna a página de cadastro
    }
    
		@PostMapping("/entrar")
		public String logou(@ModelAttribute Login_db login, HttpSession session, Model model) {
		    System.out.println("Iniciando método logou...");
		    System.out.println("login " + login.getEmail() + " senha " + login.getSenha());
		
		    boolean credenciaisCorretas = validarCredenciais(login.getEmail(), login.getSenha());
		    boolean isAdmin = isAdmin(login.getEmail(), login.getSenha());
		  
		    if (!credenciaisCorretas && !isAdmin) {
		        System.out.println("recusado");
		        model.addAttribute("erroLogin", "* Credenciais inválidas. Por favor, tente novamente.");
		        return "login";
		    }
		
		    session.setAttribute("usuarioAutenticado", true);
		
		    if (isAdmin) {
		        session.setAttribute("usuarioAdmin", true);
		        model.addAttribute("is_admin", true);
		        model.addAttribute("nome", "Administrador");
		        System.out.println("Usuário reconhecido como administrador.");
		    } else {
		        String plano = servicesLogin.findPlanosByEmail(login.getEmail()); //sem check null pq sempre tem plano ao logar
		        model.addAttribute(plano, true);
		        String nomeCompleto = servicesLogin.findNameByEmail(login.getEmail());
		        if (nomeCompleto != null) {
		            String primeiroNome = nomeCompleto.split(" ")[0];
		            model.addAttribute("nome", primeiroNome);
		        }
		    }
		    return "entrar";
}

    private boolean validarCredenciais(String email, String senha) {
        Login_db user = servicesLogin.validarCredenciais(email, senha);
        return user != null;
    }
    
    private boolean isAdmin(String email, String senha) {
        Admin_db user = servicesLogin.isAdmin(email, senha);
        return user != null;
    }
    
    @Transactional
    @PostMapping("/cadastrar")
    public String cadastro(Model model, UserModel userModel, Login_db login, UserPlans plans, RedirectAttributes redirectAttributes) {
    	if (!servicesLogin.loginAdmExistsByEmail(login.getEmail()) && !servicesLogin.loginExistsByEmail(login.getEmail())) {
    		userModel.setStatus_academia("Ativo");
    		String data = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyddMM"));
    		
	    	servicesLogin.save(userModel);
	    	
	    	userModel.setMatricula(Integer.parseInt(data + userModel.getID())); 
	    	
	    	servicesLogin.save(userModel);
	    	
	    	servicesLogin.registerLogin(userModel.getMatricula(), 
							    			login.getEmail(),
							    			login.getSenha());

	    	servicesLogin.registerUserPlans(userModel.getMatricula(), 
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
