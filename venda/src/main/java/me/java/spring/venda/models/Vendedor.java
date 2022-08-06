package me.java.spring.venda.models;

import java.util.Objects;

public class Vendedor {
	
	private int id;
	private String nome;
	
	
	
	public Vendedor(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	
	
	

}
