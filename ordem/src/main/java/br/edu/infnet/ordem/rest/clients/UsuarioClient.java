package br.edu.infnet.ordem.rest.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.ordem.rest.dtos.UsuarioDTO;

@FeignClient("usuario")
public interface UsuarioClient {

	@GetMapping("/usuarios")
	List<UsuarioDTO> listarUsuarios();

	@GetMapping("/usuarios/{id}")
	UsuarioDTO obterUsuarioPorId(@PathVariable Long id);

}
