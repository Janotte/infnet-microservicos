package br.edu.infnet.ordem.rest.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.ordem.rest.dtos.request.ProdutoRequest;

@FeignClient("catalogo")
public interface ProdutoClient {

	@GetMapping("/produtos")
	ResponseEntity<List<ProdutoRequest>> listarProdutos();

	@GetMapping("/produtos/{id}")
	ResponseEntity<ProdutoRequest> obterProduto(@PathVariable Long id);
}
