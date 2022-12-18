package br.edu.infnet.ordem.domain.services;

import java.util.ArrayList;
import java.util.List;

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
import br.edu.infnet.ordem.rest.clients.PessoaClient;
import br.edu.infnet.ordem.rest.clients.ProdutoClient;
import br.edu.infnet.ordem.rest.clients.UsuarioClient;
import br.edu.infnet.ordem.rest.dtos.request.OrdemRequest;
import br.edu.infnet.ordem.rest.dtos.request.OrdemUpdate;
import br.edu.infnet.ordem.rest.dtos.request.ProdutoRequest;
import br.edu.infnet.ordem.rest.dtos.response.ItemProdutoResponse;
import br.edu.infnet.ordem.rest.dtos.response.MessageResponse;
import br.edu.infnet.ordem.rest.dtos.response.OrdemDto;
import br.edu.infnet.ordem.rest.dtos.response.OrdemResponse;
import br.edu.infnet.ordem.rest.dtos.response.PessoaResponse;
import br.edu.infnet.ordem.rest.dtos.response.UsuarioResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrdemServiceImpl implements OrdemService {

	private final OrdemRepository ordemRepository;

	private final OrdemMapper ordemMapper = OrdemMapper.INSTANCE;
	
	private UsuarioClient usuarioClient;
	
	private PessoaClient pessoaClient;
	
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

	public List<OrdemDto> obterTodas() {
		List<Ordem> ordens = ordemRepository.findAll();
		List<OrdemDto> ordensDtos = new ArrayList<>();
		for (Ordem ordem : ordens) {
			OrdemDto ordemDto = obterPorId(ordem.getId());
			ordensDtos.add(ordemDto);
		}
		return ordensDtos;
	}

	public OrdemDto obterPorId(Long id) {
		Ordem ordem = obterOuFalhar(id);
		UsuarioResponse usuarioResponse = usuarioClient.obterUsuarioPorId(ordem.getUsuarioId());
		PessoaResponse pessoaResponse = pessoaClient.obterPessoa(ordem.getClienteId());
		OrdemDto ordemDto = new OrdemDto();
		BeanUtils.copyProperties(ordem, ordemDto, "clientId", "usuarioId");
		ordemDto.setUsuario(usuarioResponse);
		ordemDto.setCliente(pessoaResponse);
		List<ItemProdutoResponse> items = new ArrayList<>();
		ordemDto.setProdutos(items);
		items.addAll(ordemMapper.toResponseList(ordem.getProdutos()));
		return ordemDto;
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
