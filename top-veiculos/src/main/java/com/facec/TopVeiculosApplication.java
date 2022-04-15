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

import com.facec.model.Carro;
import com.facec.model.Cliente;
import com.facec.repository.CarroRepository;
import com.facec.repository.ClienteRepository;

@SpringBootApplication
public class TopVeiculosApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TopVeiculosApplication.class, args);
	}
	@Autowired
	ClienteRepository clirepo;
	
	@Autowired
	CarroRepository carrepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente("", "","","");
		cli=valida(cli);
		
		Cliente cli2 = new Cliente("Josephe Joestar", "12091014087","Rua de asfalto","jojoBT@teste");
		Cliente cli3 = new Cliente("Jotaro Kujo", "15049632021","Rua de terrao","jojoSC@teste");
		Cliente cli4 = new Cliente("Josuke Hishigata", "04391920050","Rua de paralelepipedo","jojoDB@teste");
		Cliente cli5 = new Cliente("Giorno Giovana", "30652004067","Rua de terra roxa","jojoGW@teste");
		clirepo.save(cli2);
		clirepo.save(cli3);
		clirepo.save(cli4);
		clirepo.save(cli5);
		
		
		
		Carro car1 = new Carro("BMW","Esportivo","PFPC123",clirepo.getById(1));
		Carro car2 = new Carro("FIAT","uno quadrado","PFDM7879",clirepo.getById(2));
		Carro car3 = new Carro("Car","Esportivo","PFPC133",clirepo.getById(1));
		Carro car4 = new Carro("GOl","quadrado","PFDM123",clirepo.getById(4));
		Carro car5 = new Carro("Ferrari","Esportivo","PFPC113",clirepo.getById(1));
		Carro car6 = new Carro("Chevrolet","Passeio","PFC1277",clirepo.getById(3));
		Carro car7 = new Carro("Ford","Mustang","PFDM223",clirepo.getById(2));
		Carro car8 = new Carro("Renault","Rally","PFDM1113",clirepo.getById(2));
		Carro car9 = new Carro("BMW","Esportivo","PFPC123",clirepo.getById(4));
		Carro car10 = new Carro("BMW","Passeio","FPC1234",clirepo.getById(3));
		Carro car11 = new Carro("BMW","Esportivo","PFTT123",clirepo.getById(4));
		Carro car12 = new Carro("Chevrolet","Esportivo","PF333",clirepo.getById(3));
		carrepo.save(car1);
		carrepo.save(car2);
		carrepo.save(car3);
		carrepo.save(car4);
		carrepo.save(car5);
		carrepo.save(car6);
		carrepo.save(car7);
		carrepo.save(car8);
		carrepo.save(car9);
		carrepo.save(car10);
		carrepo.save(car11);
		carrepo.save(car12);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Lista com Cliente ");
		carrepo.findAll().forEach(cl->{
			System.out.println(cl.getId()+" | "+cl.getMarca()+" | "+cl.getModelo()+" | "+cl.getPlaca()+" | "+cl.getCliente().getNome());
		});
		
		Optional<Cliente> o = clirepo.findById(2); 
		cli2 = o.get();
		cli2.setNome("Alterado Joestar ");
		cli2.setCpf("81092893040");
		cli2.setEndereco("rua de terra roxa");
		cli2.setEmail("email@teste");
		clirepo.save(cli2);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Lista com Cliente alterado");
		carrepo.findAll().forEach(cl->{
			System.out.println(cl.getId()+" | "+cl.getMarca()+" | "+cl.getModelo()+" | "+cl.getPlaca()+" | "+cl.getCliente().getNome());
		});
		
		carrepo.deleteById(1);
		carrepo.deleteById(3);
		carrepo.deleteById(5);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Lista com Cliente excluido");
		carrepo.findAll().forEach(cl->{
			System.out.println(cl.getId()+" | "+cl.getMarca()+" | "+cl.getModelo()+" | "+cl.getPlaca()+" | "+cl.getCliente().getNome());
		});
		
	}
	
	
	private Cliente valida (Cliente cli) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Cliente>> constraintviolation = validator.validate(cli);
		
		for(ConstraintViolation erro: constraintviolation) {
			System.out.println(erro.getMessageTemplate());
		}
		if(!constraintviolation.isEmpty())
			return cli;
		
		return clirepo.save(cli);
	}
}
