package com.zenith.gym.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zenith.gym.logins.Admin_db;

public interface LoginAdmRepository extends CrudRepository<Admin_db, Integer> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Admin_db u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);
    
    @Query("SELECT u FROM Admin_db u WHERE u.email = :email AND u.senha = :senha")
    Admin_db login(@Param("email") String email, @Param("senha") String senha);
    
    Admin_db findByEmailAndSenha(String email, String senha);
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Admin_db(id, email, senha) VALUES (:id, :email, :senha)", nativeQuery = true)
    void cadastrarLogin(@Param("id") Integer id, @Param("email") String email, @Param("senha") String senha);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Admin_db SET email = :email, senha = :senha WHERE id = :id", nativeQuery = true)
    void updateLogin(@Param("id") Integer id, @Param("email") String email, @Param("senha") String senha);

}
