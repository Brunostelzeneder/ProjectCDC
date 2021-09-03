package br.com.chogatao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.chogatao.model.Estado;

@Component
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Optional<Estado> findBynomeEstado(String nomeEstado);

}
