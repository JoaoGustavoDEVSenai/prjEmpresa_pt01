package com.JoaoGustavo.PrjEmpressa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.JoaoGustavo.PrjEmpressa.entities.Funcionario;
import com.JoaoGustavo.PrjEmpressa.services.FuncionarioService;


public class FuncionarioController {

public final FuncionarioService funcionarioService;
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/{funCodigo}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long depCodigo) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(depCodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}

	public List<Funcionario> getAllFuncionario() {
		return funcionarioService.getAllFuncionario();
	}

	@DeleteMapping("/{funCodigo}")
	public void deleteFuncionario(@PathVariable Long depCodigo) {
		funcionarioService.deleteFuncionario(depCodigo);
	}
	
		@GetMapping
		public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Funcionario> departamento = funcionarioService.getAllFuncionario();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(departamento);
		}
		
		@PutMapping("/{funCodigo}")
		public Funcionario updateFuncionario(@PathVariable Long funCodigo, @RequestBody Funcionario funcionario) {
		    return funcionarioService.updateFuncionario(funCodigo, funcionario);
		}
	
}