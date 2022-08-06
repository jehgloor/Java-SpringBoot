package me.java.spring.venda.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendedor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	//@OneToMany(mappedBy = "vendedor")
	//private Venda venda;
	
	public Vendedor() {}
	
	public Vendedor(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public Vendedor(int id, String nome, Venda venda) {
		this.id = id;
		this.nome = nome;
		//this.venda = venda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Venda getVenda() {
//		return venda;
//	}

//	public void setVenda(Venda venda) {
//		this.venda = venda;
//	}
//	
	
	
	

}
