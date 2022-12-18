package br.edu.infnet.catalogo.domain.services;

import java.util.List;

import br.edu.infnet.catalogo.rest.dtos.request.CategoriaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.CategoriaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.CategoriaResponse;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;

public interface CategoriaService {

	List<CategoriaResponse> obterTodos();

	CategoriaResponse obterPorId(Long id);

	MessageResponse salvar(CategoriaRequest categoriaRequest);

	MessageResponse atualizar(Long id, CategoriaUpdate categoriaUpdate);

	MessageResponse excluir(Long id);
}
