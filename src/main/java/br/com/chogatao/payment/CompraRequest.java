package br.com.chogatao.payment;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

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
	
//	@NotNull
//	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
//	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public CompraRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade,Long idPais, Long idEstado, @NotBlank String telefone,
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

	
	
	public CompraRequest() {
		
	}



	public String getEmail() {
		return email;
	}



	public String getNome() {
		return nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public String getEndereco() {
		return endereco;
	}



	public String getComplemento() {
		return complemento;
	}



	public String getCidade() {
		return cidade;
	}



	public Long getIdPais() {
		return idPais;
	}



	public Long getIdEstado() {
		return idEstado;
	}



	public String getTelefone() {
		return telefone;
	}



	public String getCep() {
		return cep;
	}



	public String  getDocumento() {
		return this.documento;
		
		
	}

	public boolean documentoValido() {
		Assert.hasLength(documento, "você nao deveria validar o documento se ele não foi preenchido");
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
	}



	@Override
	public String toString() {
		return "Dados do comprador: " + " Email "+ email + " Nome: " + nome + " Sobrenome: " + sobrenome + " documento: "
				+ documento + " endereco: " + endereco + " complemento " + complemento + " cidade: " + cidade
				+ " Pais: " + idPais + " Estado: " + idEstado + " Telefone: " + telefone + " Cep: " + cep;
	}
	
	

}
