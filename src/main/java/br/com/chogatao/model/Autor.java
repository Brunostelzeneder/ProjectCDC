package br.com.chogatao.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotNull
	private String nome;
	
	@NotNull
	@Email(message = "Precisa ser um email válido!")
	private String email;
	
	@NotNull
	@Size(min = 5, max = 400, message = "Tamanho minimo de 4 caracteres")
	private String descricao;
	
	
	private LocalDateTime criadoem = LocalDateTime.now();

	


	@Deprecated
	public Autor() {
		
	}
	
	
	

	public Autor(String nome, String email,
			String descricao)
			 {

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}




	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getCriadoem() {
		return criadoem;
	}
	


}
