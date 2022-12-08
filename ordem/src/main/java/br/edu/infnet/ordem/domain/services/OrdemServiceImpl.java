package br.edu.infnet.ordem.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.ordem.domain.entities.Ordem;
import br.edu.infnet.ordem.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.ordem.domain.repositories.OrdemRepository;

@Service
public class OrdemServiceImpl implements OrdemService {

	@Autowired
	OrdemRepository ordemRepository;

	public List<Ordem> obterTodos() {
		return ordemRepository.findAll();
	}

	public Ordem obterPorId(Long id) {
		Optional<Ordem> ordem = ordemRepository.findById(id);
		if (ordem.isEmpty())
			throw new EntidadeNaoEncontradaException(
					String.format("A ordem de serviço de id %s não foi encontrada!", id));
		return ordem.get();
	}

	public Ordem salvar(Ordem ordem) {
		return ordemRepository.save(ordem);
	}

	public Ordem atualizar(Long id, Ordem ordem) {
		Ordem ordemPorId = obterPorId(id);
		BeanUtils.copyProperties(ordem, ordemPorId, "id", "dataRegistro", "dataAtualizacao");
		return ordemRepository.save(ordemPorId);
	}
}
