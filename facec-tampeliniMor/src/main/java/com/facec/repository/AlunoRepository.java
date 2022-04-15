package com.facec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer> {

	public Optional<Aluno> findById(int id);
	
	public List<Aluno> findByNome(String nome);

	
	
	
}
