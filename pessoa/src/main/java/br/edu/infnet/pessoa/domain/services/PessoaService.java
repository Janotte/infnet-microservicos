package br.edu.infnet.pessoa.domain.services;

import java.util.List;

import br.edu.infnet.pessoa.rest.dtos.MessageResponse;
import br.edu.infnet.pessoa.rest.dtos.PessoaRequest;
import br.edu.infnet.pessoa.rest.dtos.PessoaResponse;
import br.edu.infnet.pessoa.rest.dtos.PessoaUpdate;

public interface PessoaService {

	List<PessoaResponse> obterTodas();

	PessoaResponse obterPorId(Long id);

	PessoaResponse obterPorCpfCnpj(String cpfCnpj);

	MessageResponse salvar(PessoaRequest pessoaRequest);

	MessageResponse atualizar(Long id, PessoaUpdate pessoaUpdate);

	MessageResponse excluir(Long id);

	MessageResponse ativar(Long id);

	MessageResponse inativar(Long id);
}