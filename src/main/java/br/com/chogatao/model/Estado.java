package br.com.chogatao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estado")
public class Estado {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O estado não pode ser nulo")
	private String nomeEstado;
	
	@NotNull(message = "O pais não pode ser nulo")
	@ManyToOne()
	@JsonIgnoreProperties("estado")
	private Pais pais;

	
	@Deprecated
	public Estado() {
	
	}

	

	public Long getId() {
		return id;
	}



	public String getNomeEstado() {
		return nomeEstado;
	}


	public Pais getPais() {
		return pais;
	}

	
	public boolean pertenceAPais(Pais pais) {
		
		return this.pais.equals(pais);
	}
	
	
	

}
