package com.JoaoGustavo.PrjEmpressa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depCodigo;
	
	private String depNome;
	
	public Long getdepCodigo(){
		return depCodigo;
	}
	
	public void setdepCodigo(Long depCodigo){
		this.depCodigo = depCodigo;
	}
	
	public String getdepNome(){
		return depNome;
	}
	
	public void setdepNome(String depNome) {
		this.depNome = depNome;
	}
	
}