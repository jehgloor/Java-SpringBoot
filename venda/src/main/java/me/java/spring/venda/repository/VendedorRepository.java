package me.java.spring.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.java.spring.venda.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor,Long>{

	List<Vendedor> findByNome(String nome);

}
