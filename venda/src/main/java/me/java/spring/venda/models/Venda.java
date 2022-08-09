package me.java.spring.venda.models;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Venda {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataVenda = LocalDate.now();
	private double valorVenda;
	@ManyToOne
	private Vendedor vendedor;
	
	public Venda() {}

	public Venda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Venda(double valorVenda,Vendedor vendedor) {
		this.vendedor = vendedor;
		this.valorVenda = valorVenda;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dataVenda, id, valorVenda, vendedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(dataVenda, other.dataVenda) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(valorVenda) == Double.doubleToLongBits(other.valorVenda)
				&& Objects.equals(vendedor, other.vendedor);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}
