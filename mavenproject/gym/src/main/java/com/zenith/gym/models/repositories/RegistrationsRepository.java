package com.zenith.gym.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zenith.gym.models.UserModel;

public interface RegistrationsRepository extends CrudRepository<UserModel, Integer> {

    @Query(value="SELECT CASE WHEN count(1) > 0 THEN true ELSE false END FROM UserModel u WHERE u.id = :id")
    public boolean exist(@Param("id") int id);
    
    @Query("INSERT INTO UserModel(matricula, RG, nome_completo, data_nascimento, sexo, endereço, plano_academia, status_academia) " +
            "VALUES (:matricula, :rg, :nomeCompleto, :dataNascimento, :sexo, :endereco, :planoAcademia, :statusAcademia)")
     UserModel cadastrarUsuario(@Param("matricula") String matricula,
    		 				@Param("rg") String rg,
                           @Param("nomeCompleto") String nomeCompleto,
                           @Param("dataNascimento") String string,
                           @Param("sexo") String sexo,
                           @Param("endereco") String endereco,
                           @Param("planoAcademia") String planoAcademia,
                           @Param("statusAcademia") String statusAcademia);

}
