package com.programacaojava8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import exercicio.Aluno;
import exercicio.AlunoDAO;

@SpringBootApplication
public class Programacao8JavaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Programacao8JavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		AlunoDAO dao = new AlunoDAO();
		
		System.out.println("Lista Original");
		
		dao.consultar().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("lista com o Astolfo");
		dao.inserir(new Aluno("Astolfo","ADS"));  dao.consultar().forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("lista alterada");
		Aluno altera= new Aluno (4,"altera","ADS");
		
		if(dao.atualizar(altera)) {
		dao.consultar().forEach(p->{
			System.out.println(p.toString());
		});}
		
		System.out.println("Lista sem a alteração");
		 if(dao.deletar(4)) {
		 dao.consultar().forEach(p->{
				System.out.println(p.toString());
			});}
		dao.closeConnection();
		
		
	}

}
