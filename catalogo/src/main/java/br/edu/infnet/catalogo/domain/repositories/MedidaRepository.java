package br.edu.infnet.catalogo.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.catalogo.domain.entities.Medida;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Long>{
	Optional<Medida> findByNome(String nome);
	Optional<Medida> findBySigla(String sigla);
}
