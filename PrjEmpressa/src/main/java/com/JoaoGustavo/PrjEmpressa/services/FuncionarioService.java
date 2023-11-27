package com.JoaoGustavo.PrjEmpressa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JoaoGustavo.PrjEmpressa.entities.Funcionario;
import com.JoaoGustavo.PrjEmpressa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario getFuncionarioById(Long funCodigo) {
		return funcionarioRepository.findById(funCodigo).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public void deleteFuncionario(Long depCodigo) {
		funcionarioRepository.deleteById(depCodigo);
	}
	
	public Funcionario updateFuncionario(Long funCodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funCodigo);
		
		if(funcionarioOptional.isPresent() ) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setfunCodigo(novoFuncionario.getfunCodigo() );
			funcionarioExistente.setfunNome(novoFuncionario.getfunNome() );
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null;
		}
	}
	
}