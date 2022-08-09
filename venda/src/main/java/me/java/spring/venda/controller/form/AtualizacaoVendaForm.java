package me.java.spring.venda.controller.form;

import javax.validation.constraints.Min;
import me.java.spring.venda.models.Venda;
import me.java.spring.venda.repository.VendaRepository;

public class AtualizacaoVendaForm {
	@Min(0)
	private double valorVenda;
	
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Venda atualizar(Long id, VendaRepository vendaRepository) {
		Venda venda = vendaRepository.getReferenceById(id);
		venda.setValorVenda(this.valorVenda);
		return venda;
	}
}
