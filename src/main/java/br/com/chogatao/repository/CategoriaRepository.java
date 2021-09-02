package br.com.chogatao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chogatao.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {


	Optional<Categoria> findByNomeCategoria(String nomeCategoria);

}
