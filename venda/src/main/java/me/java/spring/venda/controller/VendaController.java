package me.java.spring.venda.controller;


import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import me.java.spring.venda.controller.dto.VendaDto;
import me.java.spring.venda.controller.form.AtualizacaoVendaForm;
import me.java.spring.venda.controller.form.VendaForm;
import me.java.spring.venda.models.Venda;
import me.java.spring.venda.repository.VendaRepository;
import me.java.spring.venda.repository.VendedorRepository;


@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	
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
	
	@GetMapping("/{id}")
	public VendaDto detalhar(@PathVariable Long id) {
		Venda venda = vendaRepository.getReferenceById(id);
		return new VendaDto(venda);
	}

	@Transactional
	@PostMapping
	public ResponseEntity<VendaDto> cadastrar(@RequestBody @Valid VendaForm form, UriComponentsBuilder uriBuilder) {
		Venda venda = form.converter(vendedorRepository);
		//venda.setDataVenda(LocalDate.now());
		vendaRepository.save(venda);
		URI uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendaDto(venda));
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<VendaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoVendaForm form){
		Venda venda = form.atualizar(id, vendaRepository);
		return ResponseEntity.ok(new VendaDto(venda));
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		vendaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
