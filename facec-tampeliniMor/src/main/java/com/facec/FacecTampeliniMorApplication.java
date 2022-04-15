package com.facec;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.facec.model.Aluno;
import com.facec.model.Curso;
import com.facec.repository.AlunoRepository;
import com.facec.repository.CursoRepository;

@SpringBootApplication
public class FacecTampeliniMorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FacecTampeliniMorApplication.class, args);
	}
    @Autowired
    AlunoRepository repository;
    
    @Autowired
    CursoRepository repositoryCurs;
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		cursoBD();
		alunoBD();
	}
	private void alunoBD() {
		Aluno alunoA= new Aluno("Edward Elric","12321344","Rua de Asfalto",repositoryCurs.getById(1l));
		Aluno alunoB= new Aluno("Trafalgar D. Law","12321346","Rua de Terra",repositoryCurs.getById(2l));
		Aluno alunoC= new Aluno("Jotaro Kujo","0540543346","Rua de Paralelepipedo",repositoryCurs.getById(3l));
		
		repository.save(alunoA);
		repository.save(alunoB);
		repository.save(alunoC);
		
		//listar todos
		System.out.println("Lista com todos os alunos:");
		repository.findAll().forEach(a->{
			System.out.println(a.getId()+" | "+a.getNome()+" | "+a.getCpf()+" | "+a.getEndereco()+" | "+a.getCurso().getDescricao());
		});
		System.out.println("-------------------------------------------------------------------------------------");
		Optional<Aluno> o = repository.findById(1); 
		alunoA = o.get();
		alunoA.setNome("Alfonse Elric ");
		alunoA.setCpf("999987870");
		repository.save(alunoA);
		System.out.println("Lista com aluno alterado:");
		repository.findAll().forEach(a->{
			System.out.println(a.getId()+" | "+a.getNome()+" | "+a.getCpf()+" | "+a.getEndereco()+" | "+a.getCurso().getDescricao());
		});
		System.out.println("-------------------------------------------------------------------------------------");
		repository.deleteById(1);
		System.out.println("Lista com aluno excluido:");
		repository.findAll().forEach(a->{
			System.out.println(a.getId()+" | "+a.getNome()+" | "+a.getCpf()+" | "+a.getEndereco()+" | "+a.getCurso().getDescricao());
		});
	}
	private void cursoBD() {
		Curso qui=new Curso("Quimica","Von Hohenheim");
		Curso med=new Curso("Medicina","Corazon");
		Curso bio=new Curso("Biologia","Josephe Joestar");
		
		repositoryCurs.save(qui);
		repositoryCurs.save(med);
		repositoryCurs.save(bio);
		System.out.println("Lista de cursos disponiveis:");
		repositoryCurs.findAll().forEach(c->{
			System.out.println(c.getId()+" | "+c.getDescricao()+" | "+c.getCordenador());
		});
		System.out.println("-------------------------------------------------------------------------------------");
	}

}
