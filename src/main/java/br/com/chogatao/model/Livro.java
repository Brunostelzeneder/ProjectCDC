package br.com.chogatao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank(message = "Titulo é obrigatório")
	private String titulo;
	
	@NotNull
	@Size(min = 20, max = 500, message = "Tamanho máximo de 500 caracteres")
	private String resumo;
		
	private String sumario;
	
	@NotNull
	@DecimalMin(value = "20.0")
	private BigDecimal preco;
	@Min(value = 100)
	private int numeroPagina;
	@NotNull
	@NotBlank(message = "Número do isbn é obrigatório")
	private String isbn;
	

	@JsonFormat(pattern="yyyy-MM-dd")
	@Future(message = "A data precisa estar no futuro")
	private LocalDate dataFutura;
	
	
	@ManyToOne
	@JsonIgnoreProperties("Livro")
	@NotNull(message = "Não pode ser nulo")
	private Categoria categoria;
	
	
	
	@ManyToOne
	@JsonIgnoreProperties("Livro")
	@NotNull(message = "Não pode ser nulo")
	private Autor autor;
	
	
	@Deprecated
	public Livro() {
	
	}

	

	public Livro(String titulo,String resumo,
			String sumario, BigDecimal preco, int numeroPagina,
			String isbn, LocalDate data,
			Categoria categoria,
			Autor autor) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPagina = numeroPagina;
		this.isbn = isbn;
		this.dataFutura = data;
		this.categoria = categoria;
		this.autor = autor;
	}



	public String getTitulo() {
		return titulo;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public int getNumeroPagina() {
		return numeroPagina;
	}


	public String getIsbn() {
		return isbn;
	}


	public LocalDate getData() {
		return dataFutura
				 	;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public Long getId() {
		return id;
	}


	public Autor getAutor() {
		return autor;
	}




}
