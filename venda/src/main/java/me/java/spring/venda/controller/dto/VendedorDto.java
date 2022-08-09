package me.java.spring.venda.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import me.java.spring.venda.models.Vendedor;


public class VendedorDto {

	private String nome;
	
	public VendedorDto(Vendedor vendedor ) {
		this.nome = vendedor.getNome();
	}
	
	public String getNome() {
		return nome;
	}

	public static List<VendedorDto> converter(List<Vendedor> vendedores) {
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}
}
