package br.com.chogatao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O pais não pode ser nulo")
//	@ExistsId(domainClass = Pais.class, fieldName = "nomePais")
	private String nomePais;
	

	@OneToMany(mappedBy = "pais",cascade = CascadeType.ALL )
	private List<Estado> estado;

	@Deprecated
	public Pais() {
		
	}
	
	public Long getId() {
		return id;
	}

	public String getNomePais() {
		return nomePais;
	}

	public List<Estado> getEstado() {
		return estado;
	}


	
	

}
