package com.zenith.gym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zenith.gym.logins.Admin_db;
import com.zenith.gym.logins.Login_db;
import com.zenith.gym.models.UserModel;
import com.zenith.gym.models.repositories.LoginAdmRepository;
import com.zenith.gym.models.repositories.LoginRepository;
import com.zenith.gym.models.repositories.PlansRepository;
import com.zenith.gym.models.repositories.RegistrationsRepository;

@Service
public class LoginServices {

    @Autowired
    private RegistrationsRepository repositorySQL;
    @Autowired
    private LoginRepository loginRepo;
    @Autowired
    private PlansRepository plansRepo;
    @Autowired
    private LoginAdmRepository LoginAdmRepo;
	
    
    public String findPlanosByEmail(String email) {
    	try {
    		return plansRepo.findPlanoByEmail(email);
		} catch (Exception e) {
			return "sem-plano";
		}
    }
    
    public String findNameByEmail(String email) {
    	try {
    		return plansRepo.findNameByEmail(email);
		} catch (Exception e) {
			return "Nenhum";
		}
    }
    
    public boolean loginExistsByEmail(String email) {
		return loginRepo.existsByEmail(email);
    }
    
    public boolean loginAdmExistsByEmail(String email) {
		return LoginAdmRepo.existsByEmail(email);
    }
    
    public Login_db validarCredenciais(String email, String senha) {
    	try {
			Login_db login = loginRepo.findByEmailAndSenha(email, senha);
			return login;
		} catch (Exception e) {
			System.out.println("User login not found");
			return null;
		}
    }
    
    public Admin_db isAdmin(String email, String senha) {
    	try {
			Admin_db login = LoginAdmRepo.findByEmailAndSenha(email, senha);
			return login;
		} catch (Exception e) {
			System.out.println("User admin login not found");
			return null;
		}
    }
    
    public ResponseEntity<?> save(UserModel userModel) {
    	try {
			UserModel model = repositorySQL.save(userModel);
			return new ResponseEntity<>(model, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Could not save the userModel");
		}
    }
    
    public void registerLogin(Integer matricula, String email, String senha) {
    	try {
			loginRepo.cadastrarLogin(matricula, email, senha);
		} catch (Exception e) {
			System.out.println("Could not register the userModel in SQL");
		}
    }
    
    public void registerUserPlans(Integer matricula, String RG, String nome_completo, String email, String plano_academia) {
    	try {
			plansRepo.cadastrarPlano(matricula, RG, nome_completo, email, plano_academia);
		} catch (Exception e) {
			System.out.println("Could not register the UserPlans in SQL");
		}
    }
    
}
