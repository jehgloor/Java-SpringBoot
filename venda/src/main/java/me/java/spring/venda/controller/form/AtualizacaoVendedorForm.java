package me.java.spring.venda.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import me.java.spring.venda.models.Vendedor;
import me.java.spring.venda.repository.VendedorRepository;

public class AtualizacaoVendedorForm {
	@NotNull @NotEmpty @Length(min = 2, max = 50)
	private String nome;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vendedor atualizar(Long id, VendedorRepository vendedorRepository) {
		Vendedor vendedor = vendedorRepository.getReferenceById(id);
		vendedor.setNome(this.nome);
		return vendedor;
	}

}
