package br.edu.infnet.usuario.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.usuario.core.mapper.UsuarioMapper;
import br.edu.infnet.usuario.domain.entities.Usuario;
import br.edu.infnet.usuario.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.usuario.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.usuario.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.usuario.domain.repositories.UsuarioRepository;
import br.edu.infnet.usuario.domain.utils.StringUtils;
import br.edu.infnet.usuario.rest.dtos.MessageResponse;
import br.edu.infnet.usuario.rest.dtos.UsuarioRequest;
import br.edu.infnet.usuario.rest.dtos.UsuarioResponse;
import br.edu.infnet.usuario.rest.dtos.UsuarioUpdate;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioMapper usuarioMapper;

	public MessageResponse salvar(UsuarioRequest usuarioRequest) {
		Usuario usuario = usuarioMapper.toModel(usuarioRequest);
		usuario.setNome(StringUtils.capitalize(usuario.getNome()));
		usuario.setEmail(StringUtils.makeLowerCase(usuario.getEmail()));
		usuario.setAtivo(false);
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			throw new RegraDeNegocioException(
					String.format("Operação não permitida, já existe um usuário com o e-mail %s!", usuario.getEmail()));
		UsuarioResponse usuarioResponse = usuarioMapper.toResponse(usuarioRepository.save(usuario));
		return criarMensagem("Usuário %s criado com sucesso!", usuarioResponse.getNome());
	}

	public List<UsuarioResponse> obterTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(usuarioMapper::toResponse).collect(Collectors.toList());
	}

	public UsuarioResponse obterPorId(Long id) {
		Usuario usuario = obterOuFalhar(id);
		return usuarioMapper.toResponse(usuario);
	}

	public UsuarioResponse obterPorEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("O usuário com email %s não foi encontrado!", email)));
		return usuarioMapper.toResponse(usuario);
	}

	public MessageResponse atualizar(Long id, UsuarioUpdate usuarioUpdate) {
		Usuario usuario = usuarioMapper.toModel(usuarioUpdate);
		Usuario usuarioPorId = obterOuFalhar(id);
		BeanUtils.copyProperties(usuario, usuarioPorId, "id", "dataRegistro", "dataAtualizacao");
		UsuarioResponse usuarioResponse = usuarioMapper.toResponse(usuarioRepository.save(usuarioPorId));
		return criarMensagem("Usuário %s atualizado com sucesso!", usuarioResponse.getNome());
	}

	public MessageResponse excluir(Long id) {
		Usuario usuario = obterOuFalhar(id);
		try {
			usuarioRepository.delete(usuario);
			return criarMensagem("Usuário de id %s foi excluído com sucesso!", id);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("O usuário de id %s não pode ser excluído!", id));
		}
	}

	
	@Transactional
	public MessageResponse ativar(Long id) {
		Usuario usuario = obterOuFalhar(id);
		usuario.ativar();
		usuarioRepository.save(usuario);
		return criarMensagem("Usuário de id %s foi ativado com sucesso!", usuario.getId());
	}

	@Transactional
	public MessageResponse inativar(Long id) {
		Usuario usuario = obterOuFalhar(id);
		usuario.inativar();
		usuarioRepository.save(usuario);
		return criarMensagem("Usuário de id %s foi inativado com sucesso!", usuario.getId());
	}
	
	private Usuario obterOuFalhar(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format("O usuário de id %s não foi encontrado!", id)));
		return usuario;
	}
	
	private MessageResponse criarMensagem(String mensagem, Long id) {
		return MessageResponse.builder().message(String.format(mensagem, id)).build();
	}
	
	private MessageResponse criarMensagem(String mensagem, String str) {
		return MessageResponse.builder().message(String.format(mensagem, str)).build();
	}

}
