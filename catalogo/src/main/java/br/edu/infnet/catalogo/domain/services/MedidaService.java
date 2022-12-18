package br.edu.infnet.catalogo.domain.services;

import java.util.List;

import br.edu.infnet.catalogo.rest.dtos.request.MedidaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.MedidaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.MedidaResponse;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;

public interface MedidaService {

	List<MedidaResponse> obterTodos();

	MedidaResponse obterPorId(Long id);

	MessageResponse salvar(MedidaRequest medidaRequest);

	MessageResponse atualizar(Long id, MedidaUpdate medidaUpdate);

	MessageResponse excluir(Long id);
}
