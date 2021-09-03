package br.com.chogatao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.chogatao.model.Pais;

@Component
public interface PaisRepository extends JpaRepository<Pais, Long> {

	Optional<Pais> findBynomePais(String nomePais);



}
