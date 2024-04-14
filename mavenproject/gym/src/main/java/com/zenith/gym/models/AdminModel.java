package com.zenith.gym.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	private String RG;
	private String nome;
	private String endereço;
	private Float salario;
	
	public String getEndereço() {
	    return endereço;
	}
	public void setEndereço(String endereço) {
	    this.endereço = endereço;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome_completo) {
		this.nome = nome_completo;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
}
