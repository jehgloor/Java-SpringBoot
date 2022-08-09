package me.java.spring.venda.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import me.java.spring.venda.models.Vendedor;

public class VendedorVendasDto {
	
	private String nome;
	private int qtdVendas;

	public String getNome() {
		return nome;
	}

	public VendedorVendasDto(Vendedor vendedor ) {
		this.nome = vendedor.getNome();
		this.qtdVendas = vendedor.getVendas().size();
	}

	public int getQtdVendas() {
		return qtdVendas;
	}

	public void setQtdVendas(int qtdVendas) {
		this.qtdVendas = qtdVendas;
	}
	
	public static List<VendedorVendasDto> converter(List<Vendedor> vendedores) {
		return vendedores.stream().map(VendedorVendasDto::new).collect(Collectors.toList());
	}
}
