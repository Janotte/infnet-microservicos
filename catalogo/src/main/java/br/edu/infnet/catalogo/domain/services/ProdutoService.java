package br.edu.infnet.catalogo.domain.services;

import java.util.List;

import br.edu.infnet.catalogo.rest.dtos.request.ProdutoRequest;
import br.edu.infnet.catalogo.rest.dtos.request.ProdutoUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;
import br.edu.infnet.catalogo.rest.dtos.response.ProdutoResponse;

public interface ProdutoService {

	List<ProdutoResponse> obterTodos();

	ProdutoResponse obterPorId(Long id);

	MessageResponse salvar(ProdutoRequest produtoRequest);

	MessageResponse atualizar(Long id, ProdutoUpdate produtoUpdate);

	MessageResponse excluir(Long id);

}
