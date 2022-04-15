package com.facec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

public Optional<Funcionario> findById(int id);
	
public List<Funcionario> findByNome(String nome);

}
