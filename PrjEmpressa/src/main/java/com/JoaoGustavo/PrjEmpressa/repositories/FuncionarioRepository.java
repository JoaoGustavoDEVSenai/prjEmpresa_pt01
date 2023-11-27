package com.JoaoGustavo.PrjEmpressa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JoaoGustavo.PrjEmpressa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	
	
}