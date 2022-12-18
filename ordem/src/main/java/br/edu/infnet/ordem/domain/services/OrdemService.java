package br.edu.infnet.ordem.domain.services;

import java.util.List;

import br.edu.infnet.ordem.rest.dtos.request.OrdemRequest;
import br.edu.infnet.ordem.rest.dtos.request.OrdemUpdate;
import br.edu.infnet.ordem.rest.dtos.response.MessageResponse;
import br.edu.infnet.ordem.rest.dtos.response.OrdemDto;

public interface OrdemService {

	List<OrdemDto> obterTodas();

	OrdemDto obterPorId(Long id);

	MessageResponse salvar(OrdemRequest ordemRequest);

	MessageResponse atualizar(Long id, OrdemUpdate ordemUpdate);
}
