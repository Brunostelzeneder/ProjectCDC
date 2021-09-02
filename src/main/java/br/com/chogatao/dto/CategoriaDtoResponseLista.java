package br.com.chogatao.dto;

import br.com.chogatao.model.Categoria;

public class CategoriaDtoResponseLista {

	private String nomeCategoria;

	public CategoriaDtoResponseLista(Categoria categoria) {
		
		nomeCategoria = categoria.getNomeCategoria();
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	
	
}
