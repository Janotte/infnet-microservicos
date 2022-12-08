package br.edu.infnet.catalogo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.catalogo.domain.entities.Produto;
import br.edu.infnet.catalogo.domain.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoService.obterTodos();
	}

	@GetMapping("/{id}")
	public Produto obterProduto(@PathVariable Long id) {
		return produtoService.obterPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvar(produto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
		return produtoService.atualizar(id, produto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluirProduto(@PathVariable Long id) {
		produtoService.excluir(id);
	}
}
