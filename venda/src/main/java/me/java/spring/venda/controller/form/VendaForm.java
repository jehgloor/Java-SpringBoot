package me.java.spring.venda.controller.form;

import javax.validation.constraints.Min;

import me.java.spring.venda.models.Venda;
import me.java.spring.venda.models.Vendedor;
import me.java.spring.venda.repository.VendedorRepository;

public class VendaForm {
	@Min(0)
	// ser maior ou igual a 0
	private double valorVenda;
	//private String nomeVendedor;
	private Long idVendedor;
	
	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
		public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	public Venda converter(VendedorRepository vendedorRepository) {
		Vendedor vendedor = vendedorRepository.findById(idVendedor).orElse(null);
		return new Venda(valorVenda,vendedor);
	}
}
