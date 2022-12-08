package br.edu.infnet.usuario.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.usuario.domain.entities.Usuario;
import br.edu.infnet.usuario.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.usuario.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.usuario.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.usuario.domain.repositories.UsuarioRepository;
import br.edu.infnet.usuario.domain.utils.StringUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> obterTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario obterPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isEmpty())
			throw new EntidadeNaoEncontradaException(String.format("O usuário de id %s não foi encontrado!", id));
		System.out.println("Usuário Get: " + usuario.get());
		return usuario.get();
	}

	public Usuario obterPorEmail(String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		if (usuario.isEmpty())
			throw new EntidadeNaoEncontradaException(
					String.format("O usuário com email %s não foi encontrado!", email));
		return usuario.get();
	}

	public Usuario salvar(Usuario usuario) {
		usuario.setNome(StringUtils.capitalize(usuario.getNome()));
		usuario.setEmail(StringUtils.makeLowerCase(usuario.getEmail()));
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			throw new RegraDeNegocioException(
					String.format("Operação não permitida, já existe um usuário com o e-mail %s!", usuario.getEmail()));
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario usuarioPorId = obterPorId(id);
		BeanUtils.copyProperties(usuario, usuarioPorId, "id", "dataRegistro", "dataAtualizacao");
		return usuarioRepository.save(usuarioPorId);
	}

	public void deletarPorId(Long id) {
		try {
			usuarioRepository.delete(obterPorId(id));
		} catch (Exception e) {
			throw new EntidadeEmUsoException(
					String.format("O usuário de id %s não pode ser excluído!", id));
		}
	}
}
