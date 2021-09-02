package br.com.chogatao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chogatao.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	public Optional<Autor> findByEmail(String email);

	public Optional<Autor> findByNome (String autor);

}
