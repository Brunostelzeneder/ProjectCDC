package br.com.chogatao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chogatao.genericValidator.EmailDuplicado;
import br.com.chogatao.model.Autor;
import br.com.chogatao.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AutorController{
	
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EmailDuplicado notSameEmail;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(notSameEmail);
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Autor> cadastraAutor(@RequestBody @Valid Autor autor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(autorRepository.save(autor));
		
	}
	
	@GetMapping("/visualizarTodos")
	public ResponseEntity<List<Autor>> findAllAutor() {
		return ResponseEntity.ok(autorRepository.findAll());
				
	}
	
	@GetMapping("/visualizarid={id}")
	public ResponseEntity<Autor> findById(@PathVariable Long id) {
		return autorRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity
				.notFound().build());
	}
	
	@DeleteMapping("/apagarAutor={id}")
	public void deleteById(@PathVariable Long id) {
		 autorRepository.deleteById(id);
		
	}
	
}


