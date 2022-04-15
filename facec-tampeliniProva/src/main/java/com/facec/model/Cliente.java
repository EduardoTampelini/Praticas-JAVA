package com.facec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)	
private int id;

@NotBlank(message = "Nome Invalido")
@NotNull
private String nome;

@CPF(message = "CPF Invalido")
private String cpf;

@Email(message = "E-mail Invalido")
@NotNull
private String email;

@NotBlank(message = "Enderecço Invalido")
@NotNull
@Length(min = 11,max = 120,message = "Numero de caracteres invalido")
private String endereco;

public Cliente() {
	// TODO Auto-generated constructor stub
}

public Cliente(String nome, String cpf, String endereco, String email) {
	super();
	this.nome = nome;
	this.cpf = cpf;
	this.endereco = endereco;
	this.email = email;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}


}
