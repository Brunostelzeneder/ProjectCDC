package br.com.chogatao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chogatao.genericValidator.EstadoDuplicado;
import br.com.chogatao.model.Estado;
import br.com.chogatao.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	EstadoDuplicado estadoDuplicado;
	
	@InitBinder
	public void estadoDuplicado(WebDataBinder binder) {
		binder.addValidators(estadoDuplicado);
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Estado> cadastrarEstado(@RequestBody @Valid Estado estado) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoRepository.save(estado));
		
	}

}
