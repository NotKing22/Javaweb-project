package com.zenith.gym.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zenith.gym.logins.Admin_db;
import com.zenith.gym.models.AdminModel;
import com.zenith.gym.models.repositories.AdminRepository;
import com.zenith.gym.models.repositories.LoginAdmRepository;

@Service
public class AdminServices {
	
	@Autowired
	private AdminRepository adminRepo; 
	@Autowired
	private LoginAdmRepository loginAdmRepo;
	
	public List<AdminModel> findAllAdminrepo() {
		return (List<AdminModel>) adminRepo.findAll();
	}
	
	public Optional<AdminModel> findByIDAdminrepo(int ID) {
		try {
			return adminRepo.findById(ID);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Admin_db> findAllLoginadm() {
		return (List<Admin_db>) loginAdmRepo.findAll();
	}
	
	public Optional<Admin_db> findByIDLoginadm(int ID) {
		try {
			return loginAdmRepo.findById(ID);
		} catch (Exception e) {
			return null;
		}
	}
	
	public ResponseEntity<?> deleteAdminRepoByID(int ID) {
		try {
			
			AdminModel model = adminRepo.findById(ID).orElseThrow();
			adminRepo.deleteById(model.getID());
			return new ResponseEntity<>(model, HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}
	
	public ResponseEntity<?> deleteLoginAdminRepoByID(int ID) {
		try {
			
			Admin_db model = loginAdmRepo.findById(ID).orElseThrow();
			loginAdmRepo.deleteById(model.getID());
			return new ResponseEntity<>(model, HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Identifier not found");
		}
	}
	
	public void cadastrarAdm(String RG, String nome, String endereço, Integer salario) {
		adminRepo.cadastrarAdm(RG, nome, endereço, salario);
	}
	
	public void updateAdm(Integer ID, String RG, String nome, String email, String senha, String endereço, Integer salario) {
		adminRepo.updateAdm(ID, RG, nome, endereço, salario);
		loginAdmRepo.updateLogin(ID, email, senha);
	}
	
	public void save(Admin_db login) {
		loginAdmRepo.save(login);
	}

	
	
}
