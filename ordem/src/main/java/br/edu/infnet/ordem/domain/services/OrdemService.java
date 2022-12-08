package br.edu.infnet.ordem.domain.services;

import java.util.List;

import br.edu.infnet.ordem.domain.entities.Ordem;

public interface OrdemService {

	List<Ordem> obterTodos();

	Ordem obterPorId(Long id);

	Ordem salvar(Ordem ordem);

	Ordem atualizar(Long id, Ordem ordem);
}
