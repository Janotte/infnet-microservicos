package br.edu.infnet.catalogo.domain.services;

import java.util.List;

import br.edu.infnet.catalogo.domain.entities.Categoria;

public interface CategoriaService {
	
	List<Categoria> obterTodos();

	Categoria obterPorId(Long id);

	Categoria salvar(Categoria categoria);

	Categoria atualizar(Long id, Categoria categoria);

	void excluir(Long id);
}
