package br.edu.infnet.pessoa.domain.services;

import java.util.List;

import br.edu.infnet.pessoa.domain.entities.Pessoa;

public interface PessoaService {

	List<Pessoa> obterTodos();

	Pessoa obterPorId(Long id);
	
	Pessoa obterPorCpfCnpj(String cpfCnpj);
	
	Pessoa salvar(Pessoa usuario);

	Pessoa atualizar(Long id, Pessoa pessoa);

    void excluir(Long id);
}