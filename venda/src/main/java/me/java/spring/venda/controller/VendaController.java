package me.java.spring.venda.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.java.spring.venda.controller.dto.VendaDto;
import me.java.spring.venda.models.Venda;
import me.java.spring.venda.repository.VendaRepository;


@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@GetMapping
	public List<VendaDto> lista(Double valorVenda){
		if(valorVenda == null) {
			List<Venda> vendas = vendaRepository.findAll();
			return VendaDto.converter(vendas);
		}else {
			List<Venda> vendas = vendaRepository.findByValorVenda(valorVenda);
			return VendaDto.converter(vendas);
		}
	}
}
