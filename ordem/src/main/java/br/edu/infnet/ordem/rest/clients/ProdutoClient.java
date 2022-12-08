package br.edu.infnet.ordem.rest.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.ordem.rest.dtos.ProdutoDTO;

@FeignClient("catalogo")
public interface ProdutoClient {

	@GetMapping("/produtos")
	List<ProdutoDTO> listarProdutos();

	@GetMapping("/produtos/{id}")
	ProdutoDTO obterProduto(@PathVariable Long id);
}
