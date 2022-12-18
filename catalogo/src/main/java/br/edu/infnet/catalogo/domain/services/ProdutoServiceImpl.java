package br.edu.infnet.catalogo.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.core.mappers.ProdutoMapper;
import br.edu.infnet.catalogo.domain.entities.Categoria;
import br.edu.infnet.catalogo.domain.entities.Medida;
import br.edu.infnet.catalogo.domain.entities.Produto;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.catalogo.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.catalogo.domain.repositories.CategoriaRepository;
import br.edu.infnet.catalogo.domain.repositories.MedidaRepository;
import br.edu.infnet.catalogo.domain.repositories.ProdutoRepository;
import br.edu.infnet.catalogo.domain.utils.CatalogoUtils;
import br.edu.infnet.catalogo.rest.dtos.request.ProdutoRequest;
import br.edu.infnet.catalogo.rest.dtos.request.ProdutoUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;
import br.edu.infnet.catalogo.rest.dtos.response.ProdutoResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoServiceImpl implements ProdutoService {

	private final ProdutoRepository produtoRepository;

	private final ProdutoMapper produtoMapper;

	private final CategoriaRepository categoriaRepository;

	private final MedidaRepository medidaRepository;

	public MessageResponse salvar(ProdutoRequest produtoRequest) {
		Produto produto = produtoMapper.toModel(produtoRequest);
		produto.setNome(CatalogoUtils.capitalize(produto.getNome()));
		if (produtoRepository.findByNome(produto.getNome()).isPresent())
			throw new RegraDeNegocioException(
					String.format("Operação não permitida, já existe um produto com o nome %s!", produto.getNome()));
		Categoria categoria = buscarCategoriaOuFalhar(produtoRequest.getCategoriaId());
		Medida medida = buscarMedidaOuFalhar(produtoRequest.getMedidaId());
		produto.setCategoria(categoria);
		produto.setMedida(medida);
		ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoRepository.save(produto));
		return criarMensagem("Produto de id %s criado com sucesso!", produtoResponse.getId());
	}

	public List<ProdutoResponse> obterTodos() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos.stream().map(produtoMapper::toResponse).collect(Collectors.toList());
	}

	public ProdutoResponse obterPorId(Long id) {
		Produto produto = obterOuFalhar(id);
		return produtoMapper.toResponse(produto);
	}

	public MessageResponse atualizar(Long id, ProdutoUpdate produtoUpdate) {
		Produto produto = produtoMapper.toModel(produtoUpdate);
		Produto produtoPorId = obterOuFalhar(id);
		BeanUtils.copyProperties(produto, produtoPorId, "id");
		Categoria categoria = buscarCategoriaOuFalhar(produtoUpdate.getCategoria().getId());
		Medida medida = buscarMedidaOuFalhar(produtoUpdate.getMedida().getId());
		produtoPorId.setCategoria(categoria);
		produtoPorId.setMedida(medida);
		Produto produtoAtualizado = produtoRepository.save(produtoPorId);
		return criarMensagem("Produto de id %s atualizado com sucesso!", produtoAtualizado.getId());
	}

	public MessageResponse excluir(Long id) {
		Produto produto = obterOuFalhar(id);
		try {
			produtoRepository.delete(produto);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("O produto de id %s não pode ser excluído!", id));
		}
		return criarMensagem("Produto de id %s foi excluído com sucesso!", id);
	}

	private MessageResponse criarMensagem(String mensagem, Long id) {
		return MessageResponse.builder().message(String.format(mensagem, id)).build();
	}

	private Produto obterOuFalhar(Long id) {
		Produto produto = produtoRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format("O produto de id %s não foi encontrado!", id)));
		return produto;
	}

	private Medida buscarMedidaOuFalhar(Long id) {
		Medida medida = medidaRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format("A medida com id %s não foi encontrada!", id)));
		return medida;
	}

	private Categoria buscarCategoriaOuFalhar(Long id) {
		Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("A categoria com id %s não foi encontrada!", id)));
		return categoria;
	}
}
