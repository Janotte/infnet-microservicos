package br.edu.infnet.usuario.rest.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.usuario.domain.entities.Usuario;
import br.edu.infnet.usuario.domain.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioService.obterTodos();
	}

	@GetMapping("/{id}")
	public Usuario obterUsuarioPorId(@PathVariable Long id) {
		return usuarioService.obterPorId(id);
	}
	
	@GetMapping("/email")
	@ResponseStatus(value = HttpStatus.OK)
	public Usuario obterUsuarioPorId(@RequestParam String email) {
		return usuarioService.obterPorEmail(email);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		return usuarioService.atualizar(id, usuario);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluirUsuario(@PathVariable Long id) {
		usuarioService.deletarPorId(id);
	}
}
