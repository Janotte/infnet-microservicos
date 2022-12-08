package br.edu.infnet.catalogo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.domain.entities.Produto;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.catalogo.domain.repositories.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CategoriaServiceImpl categoriaService;
	
	@Autowired
	MedidaServiceImpl medidaService;

	public List<Produto> obterTodos() {
		return produtoRepository.findAll();
	}

	public Produto obterPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isEmpty())
			throw new EntidadeNaoEncontradaException(String.format("O produto de id %s não foi encontrado!", id));
		return produto.get();
	}

	public Produto salvar(Produto produto) {
		produto.setCategoria(categoriaService.obterPorId(produto.getCategoria().getId()));
		produto.setMedida(medidaService.obterPorId(produto.getMedida().getId()));
		return produtoRepository.save(produto);
	}

	public Produto atualizar(Long id, Produto produto) {
		Produto produtoPorId = obterPorId(id);
		BeanUtils.copyProperties(produto, produtoPorId, "id");
		return produtoRepository.save(produtoPorId);
	}

	public void excluir(Long id) {
		Produto produto = obterPorId(id);
		try {
			produtoRepository.delete(produto);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(
					String.format("O produto de id %s não pode ser excluído!", id));
		}
	}
}
