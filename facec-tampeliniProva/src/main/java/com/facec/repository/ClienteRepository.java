package com.facec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.facec.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	public Optional<Cliente> findById(int id);
	
	public List<Cliente> findByNome(String nome);

	
	
	
}
