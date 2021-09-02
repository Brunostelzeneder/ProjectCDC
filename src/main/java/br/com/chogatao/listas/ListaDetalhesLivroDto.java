package br.com.chogatao.listas;

import java.math.BigDecimal;

import br.com.chogatao.dto.AutorDtoResponseLista;
import br.com.chogatao.dto.CategoriaDtoResponseLista;
import br.com.chogatao.model.Livro;

public class ListaDetalhesLivroDto {

	
	private String titulo;
	
	private String sumario;
	
	private String resumo;
	
	private BigDecimal preco;
	
	private String isbn;
	
	private CategoriaDtoResponseLista categoria;
	
	public AutorDtoResponseLista autor;
	

	
	
	
	public ListaDetalhesLivroDto(Livro livros) {
		titulo = livros.getTitulo();
		sumario = livros.getSumario();
		resumo = livros.getResumo();
		preco = livros.getPreco();
		isbn = livros.getIsbn();
		autor = new AutorDtoResponseLista(livros.getAutor());
		categoria = new CategoriaDtoResponseLista(livros.getCategoria());
		}




	public String getTitulo() {
		return titulo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getResumo() {
		return resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getIsbn() {
		return isbn;
	}


	public CategoriaDtoResponseLista getCategoria() {
		return categoria;
	}

	public AutorDtoResponseLista getAutor() {
		return autor;
	}



}
