package com.JoaoGustavo.PrjEmpressa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funCodigo;
	
	private String funNome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funNascimento;
		
	private Long funSalario;
	
	public Long getfunCodigo(){
		return funCodigo;
	}
	
	public void setfunCodigo(Long funCodigo){
		this.funCodigo = funCodigo;
	}
	
	public String getfunNome(){
		return funNome;
	}
	
	public void setfunNome(String funNome) {
		this.funNome = funNome;
	}
	
	public LocalDate getfunNascimento(){
		return funNascimento;
	}
	
	public void setfunNascimento(LocalDate funNascimento) {
		this.funNascimento = funNascimento;
	}
	
	public Long getfunSalario(){
		return funSalario;
	}
	
	public void setfunSalario(Long funSalario) {
		this.funSalario = funSalario;
	}
	
}