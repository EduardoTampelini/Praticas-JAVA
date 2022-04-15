package com.facec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carro {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String marca;
private String modelo;
private String placa;

@ManyToOne
@JoinColumn(name = "id_cliente")
private Cliente cliente;

public Carro() {
	// TODO Auto-generated constructor stub
}

public Carro(String marca, String modelo, String placa, Cliente cliente) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.placa = placa;
	this.cliente = cliente;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


}
