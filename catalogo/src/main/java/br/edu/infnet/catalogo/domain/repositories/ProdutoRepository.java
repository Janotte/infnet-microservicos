package br.edu.infnet.catalogo.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.catalogo.domain.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Optional<Produto> findByNome(String nome);
}
