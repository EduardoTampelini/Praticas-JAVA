package com.facec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Carro;
import com.facec.model.Cliente;

public interface CarroRepository extends JpaRepository<Carro,Integer>{

public Optional<Carro> findById(int id);
	
	public List<Carro> findByNome(String marca);

}
