package com.zenith.gym.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zenith.gym.models.UserModel;

public interface RegistrationsRepository extends CrudRepository<UserModel, Integer> {

    @Query(value="SELECT CASE WHEN count(1) > 0 THEN true ELSE false END FROM UserModel u WHERE id = :id")
    public boolean exist(@Param("id") int id);
    
    @Query("INSERT INTO UserModel(matricula, RG, nome_completo, data_nascimento, sexo, endereço, plano_academia, status_academia) " +
            "VALUES (:matricula, :rg, :nome_completo, :data_nascimento, :sexo, :endereco, :plano_academia, :status_academia)")
     UserModel cadastrarUsuario(@Param("matricula") String matricula,
    		 				@Param("rg") String rg,
                           @Param("nome_completo") String nomeCompleto,
                           @Param("data_nascimento") String data_nascimento,
                           @Param("sexo") String sexo,
                           @Param("endereco") String endereco,
                           @Param("plano_academia") String planoAcademia,
                           @Param("status_academia") String statusAcademia);
    
	@Transactional
	@Modifying
	@Query("UPDATE UserModel SET matricula = :matricula, RG = :rg, data_nascimento = :data_nascimento, nome_completo = :nome_completo, sexo = :sexo, endereço = :endereco, plano_academia = :plano_academia, status_academia = :status_academia WHERE id = :id")
	void updateUsuario(@Param("matricula") String matricula,
				@Param("rg") String rg,
                @Param("nome_completo") String nomeCompleto,
                @Param("data_nascimento") String data_nascimento,
                @Param("sexo") String sexo,
                @Param("endereco") String endereco,
                @Param("plano_academia") String planoAcademia,
                @Param("status_academia") String statusAcademia,
                @Param("id") Integer ID);

}
