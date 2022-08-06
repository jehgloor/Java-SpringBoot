package me.java.spring.venda.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.java.spring.venda.controller.dto.VendedorDto;
import me.java.spring.venda.models.Vendedor;

@RestController
public class VendedorController {
	
	@RequestMapping("/vendedor")
	public List<VendedorDto> lista(){
		Vendedor vendedor = new Vendedor(3,"Luiz");
		
		return VendedorDto.converter(Arrays.asList(vendedor,vendedor));
	}

}
