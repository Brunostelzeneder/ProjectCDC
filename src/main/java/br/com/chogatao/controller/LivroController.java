package br.com.chogatao.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chogatao.genericValidator.IsbnDuplicado;
import br.com.chogatao.genericValidator.TituloDuplicado;
import br.com.chogatao.listas.ListaDetalhesLivroDto;
import br.com.chogatao.model.Livro;
import br.com.chogatao.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository LivroRepository;
	

	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	TituloDuplicado tituloDuplicado;
	
	@Autowired
	IsbnDuplicado isbnDuplicado;
	
	@InitBinder
	public void initTitulo(WebDataBinder binder) {
		binder.addValidators(tituloDuplicado);
	}
	
	@InitBinder
	public void initIsbn(WebDataBinder binder) {
		binder.addValidators(isbnDuplicado);
	}
	
	@PostMapping("/cadastrar")
	public  ResponseEntity<Livro> cadastrarLivro(@RequestBody @Valid Livro livro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(LivroRepository.save(livro));
		
	}
	
	@GetMapping("/listaDeLivros")
	public ResponseEntity<List<Livro>> listaDeLivros() {
		return ResponseEntity.ok(LivroRepository.findAll());
		
	}
	
	@GetMapping("/detalhes={id}")
	public ResponseEntity<?> detalhesLivro(@PathVariable Long id) {
		
		Livro livroBuscado = em.find(Livro.class, id);
		
		if(livroBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		
		ListaDetalhesLivroDto detalhesLivro = new ListaDetalhesLivroDto(livroBuscado);
		return ResponseEntity.ok(detalhesLivro);
	}

}
