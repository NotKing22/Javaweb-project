package com.zenith.gym.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zenith.gym.logins.Login_db;
import com.zenith.gym.models.UserModel;
import com.zenith.gym.models.UserPlans;
import com.zenith.gym.models.repositories.LoginRepository;
import com.zenith.gym.models.repositories.PlansRepository;
import com.zenith.gym.models.repositories.RegistrationsRepository;

@Service
public class ClientServices {

	@Autowired
	private RegistrationsRepository registrationRepo;
	@Autowired
	private PlansRepository plansRepo;
	@Autowired
	private LoginRepository loginRepo;
	
	public List<UserModel> findAllRegistrationRepo() {
		return (List<UserModel>) registrationRepo.findAll();
	}
	
	public Optional<UserModel> findByIDregistrationRepo(Integer ID) {
		try {
			
			return registrationRepo.findById(ID);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public Optional<Login_db> findByIDlogin(Integer ID) {
		try {
			
			return loginRepo.findById(ID);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public Optional<UserPlans> findByIDplans(Integer ID) {
		try {
			
			return plansRepo.findById(ID);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public ResponseEntity<?> deleteByIDlogin(Integer ID) {
		try {
			 loginRepo.deleteById(ID);
			 
			 Login_db login = loginRepo.findById(ID).orElseThrow();
			 loginRepo.delete(login);
			 return new ResponseEntity<>(login, HttpStatus.OK);
			 
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}
	
	public ResponseEntity<?> deleteByIDplans(Integer ID) {
		try {
			UserPlans plans = plansRepo.findById(ID).orElseThrow();
			
			plansRepo.delete(plans);
			
			return new ResponseEntity<>(plans, HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}
	
	public ResponseEntity<?> deleteByIDregistrationRepo(Integer ID) {
		try {
			UserModel model = registrationRepo.findById(ID).orElseThrow();
			
			registrationRepo.delete(model);
			
			return new ResponseEntity<>(model, HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}
	
	public ResponseEntity<?> updateLogin(Integer matricula, String email, String senha) {
		try {
			Login_db login = loginRepo.findByEmailAndSenha(email, senha);
			loginRepo.updateLogin(matricula, email, senha);
			return new ResponseEntity<>(login, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}

	
	public ResponseEntity<?> updateUsuario(String matricula, String RG, String nome_completo, String data_nascimento, String sexo, String endereço, String plano_academia, String status_academia, Integer ID) {
		try {
			UserModel user = registrationRepo.findById(ID).orElseThrow();
			registrationRepo.updateUsuario(matricula, RG, nome_completo, data_nascimento, sexo, endereço, plano_academia, status_academia, ID);
			
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}
	
	
	public ResponseEntity<?> updatePlans(Integer matricula, String RG, String nome_completo, String email, String plano_academia) {
		try {
			UserPlans plans = plansRepo.findById(matricula).orElseThrow();
			plansRepo.updateUsuario(matricula, RG, nome_completo, email, plano_academia);
			return new ResponseEntity<>(plans, HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}
	
}
