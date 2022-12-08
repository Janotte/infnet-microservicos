package br.edu.infnet.ordem.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.ordem.domain.entities.Ordem;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {

}
