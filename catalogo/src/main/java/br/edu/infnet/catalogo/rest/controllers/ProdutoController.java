package br.edu.infnet.catalogo.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.catalogo.domain.services.ProdutoService;
import br.edu.infnet.catalogo.rest.dtos.request.ProdutoRequest;
import br.edu.infnet.catalogo.rest.dtos.request.ProdutoUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;
import br.edu.infnet.catalogo.rest.dtos.response.ProdutoResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController {

	private static Logger log = LoggerFactory.getLogger(ProdutoController.class);
	
	private final ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<MessageResponse> criarProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
		log.info("Criando um novo Produto...");
		return new ResponseEntity<>(produtoService.salvar(produtoRequest), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoResponse>> obterTodosProdutos() {
		log.info("Buscando os Produtos...");
		return new ResponseEntity<>(produtoService.obterTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponse> obterProdutoPorId(@PathVariable Long id) {
		log.info("Buscando o Produto de id {}...", id);
		return new ResponseEntity<>(produtoService.obterPorId(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> atualizarProduto(@Valid @PathVariable Long id, @RequestBody ProdutoUpdate produtoUpdate) {
		log.info("Atualizando o Produto de id {}...", id);
		return new ResponseEntity<>(produtoService.atualizar(id, produtoUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> excluirProduto(@PathVariable Long id) {
		log.info("Excluindo o Produto de id {}...", id);
		return new ResponseEntity<>(produtoService.excluir(id), HttpStatus.OK);
	}
}
