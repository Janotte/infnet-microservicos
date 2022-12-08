package br.edu.infnet.usuario.domain.services;

import br.edu.infnet.usuario.domain.entities.Usuario;

import java.util.List;

public interface UsuarioService {

	List<Usuario> obterTodos();

	Usuario obterPorId(Long id);
	
	Usuario obterPorEmail(String email);

	Usuario salvar(Usuario usuario);

	Usuario atualizar(Long id, Usuario usuario);

    void deletarPorId(Long id);
}
