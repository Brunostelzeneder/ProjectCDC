package br.com.chogatao.payment;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.chogatao.beanCreator.ExistsId;
import br.com.chogatao.model.Estado;
import br.com.chogatao.model.Pais;

public class CompraRequest {
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "nomePais")
	private Long idPais;
	
	
	@ExistsId(domainClass = Estado.class, fieldName = "nomePais")
	private Long idEstado;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public CompraRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	

}
