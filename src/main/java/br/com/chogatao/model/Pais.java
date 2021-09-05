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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomePais == null) ? 0 : nomePais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomePais == null) {
			if (other.nomePais != null)
				return false;
		} else if (!nomePais.equals(other.nomePais))
			return false;
		return true;
	}

					
	
	

}
