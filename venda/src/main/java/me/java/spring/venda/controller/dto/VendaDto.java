package me.java.spring.venda.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import me.java.spring.venda.models.Venda;

public class VendaDto {
	private Long idVenda;
	private double valorVenda;
	private LocalDate dataVenda;
	private Long idVendedor;
	private String nomeVendedor;

	
	public VendaDto(Venda venda) {
		this.idVenda = venda.getId();
		this.valorVenda = venda.getValorVenda();
		this.dataVenda = venda.getDataVenda();
		this.idVendedor = venda.getVendedor().getId();
		this.nomeVendedor = venda.getVendedor().getNome();
	}


	public Long getIdVenda() {
		return idVenda;
	}


	public LocalDate getDataVenda() {
		return dataVenda;
	}


	public Long getIdVendedor() {
		return idVendedor;
	}


	public String getNomeVendedor() {
		return nomeVendedor;
	}


	public double getValorVenda() {
		return valorVenda;
	}

	public static List<VendaDto> converter(List<Venda> vendas) {
		return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
	}
}
