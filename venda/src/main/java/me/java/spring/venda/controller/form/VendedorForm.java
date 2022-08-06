package me.java.spring.venda.controller.form;

import me.java.spring.venda.models.Vendedor;

public class VendedorForm {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vendedor converter() {
		// TODO Auto-generated method stub
		return new Vendedor(nome);
	}
	
}
