package me.java.spring.venda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.java.spring.venda.models.Vendedor;

@Controller
public class TesteController {
	
	
	@RequestMapping("/teste")
	@ResponseBody
	public String testeConexao(){
		Vendedor nome = new Vendedor(1,"Jose");
		return "Olá "+nome.getNome()+" seu id é: "+nome.getId();
		
	}
}
