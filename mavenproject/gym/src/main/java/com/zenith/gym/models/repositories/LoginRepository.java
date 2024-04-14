package com.zenith.gym.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zenith.gym.logins.Login_db;

@Repository
public interface LoginRepository extends JpaRepository<Login_db, Integer> {
    
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Login_db u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);
    
    @Query("SELECT u FROM Login_db u WHERE u.email = :email AND u.senha = :senha")
    Login_db login(@Param("email") String email, @Param("senha") String senha);
    
    Login_db findByEmailAndSenha(String email, String senha);
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO login_db(matricula, email, senha) VALUES (:matricula, :email, :senha)", nativeQuery = true)
    void cadastrarLogin(@Param("matricula") Integer matricula, @Param("email") String email, @Param("senha") String senha);
    
}
