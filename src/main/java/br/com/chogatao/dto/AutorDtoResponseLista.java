package br.com.chogatao.dto;

import br.com.chogatao.model.Autor;

public class AutorDtoResponseLista  {
	
	private String nome;
	
	private String descricao;

	
	public AutorDtoResponseLista(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
		
		
	}


	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
	
}
