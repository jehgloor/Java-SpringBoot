package me.java.spring.venda.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.java.spring.venda.controller.dto.VendedorDto;
import me.java.spring.venda.models.Vendedor;
import me.java.spring.venda.repository.VendedorRepository;

@RestController
public class VendedorController {
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@RequestMapping("/vendedor")
	public List<VendedorDto> lista(String nome){
		if(nome == null) {
			List<Vendedor> vendedores = vendedorRepository.findAll();
			return VendedorDto.converter(vendedores);
		}else {
			List<Vendedor> vendedores = vendedorRepository.findByNome(nome);
			return VendedorDto.converter(vendedores);
		}
		
	}

}
