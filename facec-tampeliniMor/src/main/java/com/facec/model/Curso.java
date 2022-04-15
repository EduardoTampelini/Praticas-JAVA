package com.facec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id ;
	private String descricao;
	private String cordenador;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String descricao, String cordenador) {
		super();
		this.descricao = descricao;
		this.cordenador = cordenador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCordenador() {
		return cordenador;
	}

	public void setCordenador(String cordenador) {
		this.cordenador = cordenador;
	}

	
}
