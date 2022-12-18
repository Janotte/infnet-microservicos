package br.edu.infnet.ordem.rest.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.ordem.rest.dtos.response.PessoaResponse;

@FeignClient("pessoa")
public interface PessoaClient {

	@GetMapping("/pessoas")
	List<PessoaResponse> listarPessoas();

	@GetMapping("/pessoas/{id}")
	PessoaResponse obterPessoa(@PathVariable Long id);
}
