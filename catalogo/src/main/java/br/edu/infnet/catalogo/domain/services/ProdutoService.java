package br.edu.infnet.catalogo.domain.services;

import java.util.List;

import br.edu.infnet.catalogo.domain.entities.Produto;

public interface ProdutoService {

	List<Produto> obterTodos();

	Produto obterPorId(Long id);

	Produto salvar(Produto produto);

	Produto atualizar(Long id, Produto produto);

	void excluir(Long id);

}
