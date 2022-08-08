package me.java.spring.venda.controller;


import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import me.java.spring.venda.controller.dto.VendaDto;
import me.java.spring.venda.controller.form.VendaForm;
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
	
	@Transactional
	@PostMapping
	public ResponseEntity<VendaDto> cadastrar(@RequestBody @Valid VendaForm form, UriComponentsBuilder uriBuilder) {
		Venda venda = form.converter();
		vendaRepository.save(venda);
		URI uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendaDto(venda));
	}
}
