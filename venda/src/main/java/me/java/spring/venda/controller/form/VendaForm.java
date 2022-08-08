package me.java.spring.venda.controller.form;
import javax.validation.constraints.Min;
import me.java.spring.venda.models.Venda;

public class VendaForm {
	@Min(0)
	// ser maior ou igual a 0
	private double valorVenda;
	
	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public Venda converter() {
		return new Venda(valorVenda);
	}
	
}
