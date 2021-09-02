package br.com.chogatao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chogatao.genericValidator.CategoriaDuplicada;
import br.com.chogatao.model.Categoria;
import br.com.chogatao.repository.CategoriaRepository;

@RestController
@RequestMapping("/Categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaDuplicada notSameCategoria;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(notSameCategoria);
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Categoria> cadCategoria(@RequestBody @Valid Categoria categoria) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
}
