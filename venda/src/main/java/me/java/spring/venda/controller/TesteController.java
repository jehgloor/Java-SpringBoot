package me.java.spring.venda.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.java.spring.venda.models.Venda;
import me.java.spring.venda.models.Vendedor;

@RestController
public class TesteController {

	@RequestMapping("/teste")
	
	public String testeConexao(){
		return "Olá";
		
	}
}
