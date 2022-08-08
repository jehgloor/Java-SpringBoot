package me.java.spring.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.java.spring.venda.models.Venda;


public interface VendaRepository extends JpaRepository<Venda,Long>{
	List<Venda> findByValorVenda(double valor);
}
