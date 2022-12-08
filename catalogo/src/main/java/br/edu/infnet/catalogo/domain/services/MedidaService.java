package br.edu.infnet.catalogo.domain.services;

import java.util.List;

import br.edu.infnet.catalogo.domain.entities.Medida;

public interface MedidaService {

	List<Medida> obterTodos();

	Medida obterPorId(Long id);

	Medida salvar(Medida medida);

	Medida atualizar(Long id, Medida medida);

	void excluir(Long id);
}
