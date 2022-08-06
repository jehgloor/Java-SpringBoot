package me.java.spring.venda.models;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate dataVenda = LocalDate.now();
	private double valorVenda;
	
	public Venda() {}
	
	public Venda(int id, double valorVenda) {
		this.id = id;

		this.valorVenda = valorVenda;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dataVenda, id, valorVenda);
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
		return Objects.equals(dataVenda, other.dataVenda) && id == other.id
				&& Double.doubleToLongBits(valorVenda) == Double.doubleToLongBits(other.valorVenda);
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
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

}
