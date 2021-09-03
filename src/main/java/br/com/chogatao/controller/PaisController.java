package br.com.chogatao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chogatao.genericValidator.PaisDuplicado;
import br.com.chogatao.model.Pais;
import br.com.chogatao.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	PaisDuplicado paisDuplicado;
	
	@InitBinder
	public void paisDupliado(WebDataBinder binder) {
		binder.addValidators(paisDuplicado);
		
	}
	
	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Pais> cadastrarPais(@RequestBody @Valid Pais pais) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(paisRepository.save(pais));
	}
	
	@DeleteMapping("/deletar={id}")
	public void deletarPais(@PathVariable Long id) {
		paisRepository.deleteById(id);
		
	}

}
