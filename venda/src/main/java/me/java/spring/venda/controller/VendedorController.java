package me.java.spring.venda.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import me.java.spring.venda.controller.dto.VendedorDto;
import me.java.spring.venda.controller.form.VendedorForm;
import me.java.spring.venda.models.Vendedor;
import me.java.spring.venda.repository.VendedorRepository;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping
	public List<VendedorDto> lista(String nome){
		if(nome == null) {
			List<Vendedor> vendedores = vendedorRepository.findAll();
			return VendedorDto.converter(vendedores);
		}else {
			List<Vendedor> vendedores = vendedorRepository.findByNome(nome);
			return VendedorDto.converter(vendedores);
		}
	}
	
	@PostMapping
	public ResponseEntity<VendedorDto> cadastrar(@RequestBody @Valid VendedorForm form, UriComponentsBuilder uriBuilder) {
		Vendedor vendedor = form.converter();
		vendedorRepository.save(vendedor);
		URI uri = uriBuilder.path("/vendedores/{id}").buildAndExpand(vendedor.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
	}
	
	@GetMapping("/{id}")
	public VendedorDto detalhar(@PathVariable Long id) {
		//@PathVariable -> uma variavel da url
		
		Vendedor vendedor = vendedorRepository.getReferenceById(id);
		return new VendedorDto(vendedor);
		
	}
}
