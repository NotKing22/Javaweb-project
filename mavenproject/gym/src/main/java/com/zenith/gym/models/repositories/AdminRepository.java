package com.zenith.gym.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zenith.gym.models.AdminModel;

public interface AdminRepository extends CrudRepository<AdminModel, Integer>{
	
	//INSERT INTO admin_model(rg, salario, endereço, nome_completo) values ('none', 0.0, 'Nenhum', 'admin_default');

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Admin_Model(rg, nome, endereço, salario) VALUES (:rg, :nome, :endereco, :salario)", nativeQuery = true)
	void cadastrarAdm(@Param("rg") String rg, 
	                  @Param("nome") String nome, 
	                  @Param("endereco") String endereco, 
	                  @Param("salario") Integer salario);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Admin_Model SET rg = :rg, nome = :nome, endereço = :endereco, salario = :salario WHERE id = :id", nativeQuery = true)
	void updateAdm(@Param("id") int id,
	                  @Param("rg") String rg, 
	                  @Param("nome") String nome, 
	                  @Param("endereco") String endereco, 
	                  @Param("salario") Integer salario);

}
