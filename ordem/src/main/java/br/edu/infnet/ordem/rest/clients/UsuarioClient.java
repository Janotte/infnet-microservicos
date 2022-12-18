package br.edu.infnet.ordem.rest.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.ordem.rest.dtos.response.UsuarioResponse;

@FeignClient("usuario")
public interface UsuarioClient {

	@GetMapping("/usuarios")
	List<UsuarioResponse> listarUsuarios();

	@GetMapping("/usuarios/{id}")
	UsuarioResponse obterUsuarioPorId(@PathVariable Long id);

}
