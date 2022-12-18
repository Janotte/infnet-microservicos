package br.edu.infnet.usuario.domain.services;

import java.util.List;

import br.edu.infnet.usuario.rest.dtos.MessageResponse;
import br.edu.infnet.usuario.rest.dtos.UsuarioRequest;
import br.edu.infnet.usuario.rest.dtos.UsuarioResponse;
import br.edu.infnet.usuario.rest.dtos.UsuarioUpdate;

public interface UsuarioService {

	List<UsuarioResponse> obterTodos();

	UsuarioResponse obterPorId(Long id);
	
	UsuarioResponse obterPorEmail(String email);

	MessageResponse salvar(UsuarioRequest usuarioRequest);

	MessageResponse atualizar(Long id, UsuarioUpdate usuarioUpdate);

	MessageResponse excluir(Long id);
	
	MessageResponse ativar(Long id);
	
	MessageResponse inativar(Long id);
}
