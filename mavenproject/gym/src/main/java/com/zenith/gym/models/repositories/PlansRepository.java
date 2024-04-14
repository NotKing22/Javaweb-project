package com.zenith.gym.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zenith.gym.models.UserPlans;

@Repository
public interface PlansRepository extends JpaRepository<UserPlans, Integer> {
    
	@Modifying
    @Query(value = "INSERT INTO user_plans (matricula, rg, nome, email, plano_academia) " +
            "VALUES (:matricula, :rg, :nome, :email, :plano_academia)", nativeQuery = true)
    void cadastrarPlano(@Param("matricula") Integer matricula, 
                   @Param("rg") String rg, 
                   @Param("nome") String nome,
                   @Param("email") String email,
                   @Param("plano_academia") String plano_academia);
	
	@Query("SELECT p.plano_academia FROM UserPlans p WHERE p.email = :email")
	String findPlanoByEmail(@Param("email") String email);
	
}
