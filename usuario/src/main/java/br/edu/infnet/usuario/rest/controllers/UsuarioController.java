package br.edu.infnet.usuario.rest.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.usuario.domain.services.UsuarioServiceImpl;
import br.edu.infnet.usuario.rest.dtos.MessageResponse;
import br.edu.infnet.usuario.rest.dtos.UsuarioRequest;
import br.edu.infnet.usuario.rest.dtos.UsuarioResponse;
import br.edu.infnet.usuario.rest.dtos.UsuarioUpdate;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

	private static Logger log = LoggerFactory.getLogger(UsuarioController.class);

	private final UsuarioServiceImpl usuarioService;

	@PostMapping
	public ResponseEntity<MessageResponse> criarUsuario(@Valid @RequestBody UsuarioRequest usuario) {
		log.info("Criando um novo Usuário...");
		return new ResponseEntity<>(usuarioService.salvar(usuario), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UsuarioResponse>> obterTodosUsuarios() {
		log.info("Buscando os Usuários...");
		return new ResponseEntity<>(usuarioService.obterTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> obterUsuarioPorId(@PathVariable Long id) {
		log.info("Buscando o Usuário de id {}...", id);
		return new ResponseEntity<>(usuarioService.obterPorId(id), HttpStatus.OK);
	}

	@GetMapping("/email")
	public ResponseEntity<UsuarioResponse> obterUsuarioPorEmail(@RequestParam String email) {
		log.info("Buscando o Usuário com email {}...", email);
		return new ResponseEntity<>(usuarioService.obterPorEmail(email), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> atualizarUsuario(@Valid @PathVariable Long id,
			@RequestBody UsuarioUpdate usuario) {
		log.info("Atualizando o Usuário de id {}...", id);
		return new ResponseEntity<>(usuarioService.atualizar(id, usuario), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> excluirUsuario(@PathVariable Long id) {
		log.info("Excluindo o Usuário de id {}...", id);
		return new ResponseEntity<>(usuarioService.excluir(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/ativa")
	public ResponseEntity<MessageResponse> ativarUsuario(@PathVariable Long id) {
		log.info("Ativando o Usuário de id {}...", id);
		return new ResponseEntity<>(usuarioService.ativar(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}/inativa")
	public ResponseEntity<MessageResponse> inativarUsuario(@PathVariable Long id) {
		log.info("Inativando o Usuário de id {}...", id);
		return new ResponseEntity<>(usuarioService.inativar(id), HttpStatus.OK);
	}
}
