package me.java.spring.venda.models;

import java.util.Objects;

public class Vendedor {
	
	private int id;
	private String nome;
	
	public Vendedor() {}
	
	public Vendedor(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return id == other.id && Objects.equals(nome, other.nome);
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
