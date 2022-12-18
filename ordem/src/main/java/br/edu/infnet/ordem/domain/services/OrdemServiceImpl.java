package br.edu.infnet.ordem.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.ordem.core.mapper.OrdemMapper;
import br.edu.infnet.ordem.domain.entities.ItemProduto;
import br.edu.infnet.ordem.domain.entities.Ordem;
import br.edu.infnet.ordem.domain.entities.Situacao;
import br.edu.infnet.ordem.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.ordem.domain.repositories.OrdemRepository;
import br.edu.infnet.ordem.rest.clients.ProdutoClient;
import br.edu.infnet.ordem.rest.dtos.request.OrdemRequest;
import br.edu.infnet.ordem.rest.dtos.request.OrdemUpdate;
import br.edu.infnet.ordem.rest.dtos.request.ProdutoRequest;
import br.edu.infnet.ordem.rest.dtos.response.MessageResponse;
import br.edu.infnet.ordem.rest.dtos.response.OrdemResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrdemServiceImpl implements OrdemService {

	private final OrdemRepository ordemRepository;

	private final OrdemMapper ordemMapper = OrdemMapper.INSTANCE;

	private ProdutoClient produtoClient;

	@Transactional
	public MessageResponse salvar(OrdemRequest ordemRequest) {
		Ordem ordem = ordemMapper.toModel(ordemRequest);
		ordem.setSituacao(Situacao.ABERTA);
		Ordem ordemSalva = ordemRepository.save(ordem);
		for (ItemProduto item : ordemSalva.getProdutos()) {
			ProdutoRequest produtoRequest = produtoClient.obterProduto(item.getProdutoId()).getBody();
			item.setOrdem(ordemSalva);
			item.setValor(produtoRequest.getValor());
		}
		OrdemResponse ordemResponse = ordemMapper.toResponse(ordemSalva);
		return criarMensagemDTO("Ordem criada com sucesso, id: %s!", ordemResponse.getId());
	}

	public List<OrdemResponse> obterTodas() {
		List<Ordem> ordens = ordemRepository.findAll();
		return ordens.stream().map(ordemMapper::toResponse).collect(Collectors.toList());
	}

	public OrdemResponse obterPorId(Long id) {
		Ordem ordem = obterOuFalhar(id);
		return ordemMapper.toResponse(ordem);
	}

	@Transactional
	public MessageResponse atualizar(Long id, OrdemUpdate ordemUpdate) {
		Ordem ordemById = obterOuFalhar(id);
		Ordem ordem = ordemMapper.toOrdem(ordemUpdate);
		BeanUtils.copyProperties(ordem, ordemById,  "id", "dataRegistro", "dataAtualizacao" );
		Ordem ordemAtualizada = ordemRepository.save(ordem);
		for (ItemProduto item : ordemAtualizada.getProdutos()) {
			item.setOrdem(ordemAtualizada);
		}
		return criarMensagemDTO("Ordem atualizada com sucesso, id: %s!", ordemMapper.toResponse(ordemAtualizada).getId());
	}

	private MessageResponse criarMensagemDTO(String mensagem, Long id) {
		return MessageResponse.builder().message(String.format(mensagem, id)).build();
	}

	private Ordem obterOuFalhar(Long id) {
		Ordem ordem = ordemRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("A ordem de serviço de id %s não foi encontrada!", id)));
		return ordem;
	}

}
