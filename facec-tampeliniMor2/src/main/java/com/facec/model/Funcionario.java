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
public class Funcionario {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@NotBlank(message = "Nome Invalido")
@NotNull
@Length(min = 4,max = 80,message = "Numero de caracteres invalido")
private String nome;

@CPF(message = "CPF Invalido")
private String cpf;

@NotBlank(message = "Enderecço Invalido")
@NotNull
@Length(min = 11,max = 120,message = "Numero de caracteres invalido")
private String endereco;

@Email(message = "E-mail Invalido")
@NotNull
private String email;

public Funcionario() {
	// TODO Auto-generated constructor stub
}

public Funcionario(String nome, String cpf, String endereco, String email) {
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

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



}
