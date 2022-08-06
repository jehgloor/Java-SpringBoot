package me.java.spring.venda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.java.spring.venda.models.Venda;
import me.java.spring.venda.models.Vendedor;

@Controller
public class TesteController {

	@RequestMapping("/teste")
	@ResponseBody
	public String testeConexao(){
		Venda venda = new Venda(1,200.00 );
		Vendedor nome = new Vendedor(1,"Jose");
		return "Olá "+nome.getNome()+", seu id de Vendedor é: "+nome.getId()
			+"===Sua venda foi feita no dia "+venda.getDataVenda()
			+", Número do Id: "+venda.getId()+", No valor de: "+ venda.getValorVenda()+"===";
		
	}
}
