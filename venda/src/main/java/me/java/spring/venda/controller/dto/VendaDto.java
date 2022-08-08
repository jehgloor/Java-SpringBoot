package me.java.spring.venda.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import me.java.spring.venda.models.Venda;

public class VendaDto {
	private double valorVenda;

	public VendaDto(Venda venda) {
		this.valorVenda = venda.getValorVenda();
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public static List<VendaDto> converter(List<Venda> vendas) {
		return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
	}
}
