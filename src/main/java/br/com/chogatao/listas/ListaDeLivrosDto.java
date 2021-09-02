package br.com.chogatao.listas;

import br.com.chogatao.model.Livro;

public class ListaDeLivrosDto {
	
	private Long id;
	
	private String tituloLivro;
	
	
	
	@Deprecated
	public ListaDeLivrosDto() {
		
	}

	public ListaDeLivrosDto(Livro livros) {
		
		this.id = livros.getId();
		this.tituloLivro = livros.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}
	
	

}
