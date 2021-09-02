package br.com.chogatao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chogatao.model.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long>  {

	Optional<Livro> findByTitulo(String titulo);

	Optional<Livro> findByIsbn(String isbn);

}
