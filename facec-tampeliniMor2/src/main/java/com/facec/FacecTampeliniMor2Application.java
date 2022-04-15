package com.facec;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.facec.model.Funcionario;
import com.facec.repository.FuncionarioRepository;

@SpringBootApplication
public class FacecTampeliniMor2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FacecTampeliniMor2Application.class, args);
	}
    @Autowired
    FuncionarioRepository funcRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		funcionario();
	}
	private void funcionario() {
		
		Funcionario func1 = new Funcionario("Severino","06807016050", "Rua de paralepipedo", "teste2011@teste");
		funcRepo.save(func1);
		/*
		Para realizar o teste se a validação esta funcionando bata tirar do comentario,
		porem caso você tire uma linha do comentario você tem que comentar a outra linha
		*/
		
		Funcionario func = new Funcionario("astolfos ","83888965047", "Rua de pedra ", "tesete@teste");
		//Funcionario func = new Funcionario(" "," ", " ", " ");
		func = valida(func);
		
		System.out.println("Lista com todos os alunos:");
		funcRepo.findAll().forEach(a->{
			System.out.println(a.getId()+" | "+a.getNome()+" | "+a.getCpf()+" | "+a.getEndereco());
		});
		System.out.println("-------------------------------------------------------------------------------------");
		Optional<Funcionario> o = funcRepo.findById(1); 
		func1 = o.get();
		func1.setNome("Alfonse Elric ");
		func1.setCpf("81092893040");
		func1.setEndereco("rua de terra roxa");
		func1.setEmail("email@teste");
		funcRepo.save(func1);
		func.setNome("Edward");
		valida(func);
		System.out.println("Lista com aluno alterado:");
		funcRepo.findAll().forEach(a->{
			System.out.println(a.getId()+" | "+a.getNome()+" | "+a.getCpf()+" | "+a.getEndereco());
		});
		System.out.println("-------------------------------------------------------------------------------------");
		funcRepo.deleteById(1);
		System.out.println("Lista com aluno excluido:");
		funcRepo.findAll().forEach(a->{
			System.out.println(a.getId()+" | "+a.getNome()+" | "+a.getCpf()+" | "+a.getEndereco());
		});
	}
	
	private Funcionario valida (Funcionario func) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Funcionario>> constraintviolation = validator.validate(func);
		
		for(ConstraintViolation erro: constraintviolation) {
			System.out.println(erro.getMessageTemplate());
		}
		if(!constraintviolation.isEmpty())
			return func;
		
		return funcRepo.save(func);
	}

}
