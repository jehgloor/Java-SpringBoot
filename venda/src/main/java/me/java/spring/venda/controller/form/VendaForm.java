package me.java.spring.venda.controller.form;

import me.java.spring.venda.models.Venda;
import me.java.spring.venda.models.Vendedor;

public class VendaForm {
	private double valorVenda;
	
	

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public Venda converter() {
		// TODO Auto-generated method stub
		return new Venda(valorVenda);
	}
	
	
}
