package br.edu.infnet.catalogo.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.core.mappers.CategoriaMapper;
import br.edu.infnet.catalogo.domain.entities.Categoria;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.catalogo.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.catalogo.domain.repositories.CategoriaRepository;
import br.edu.infnet.catalogo.domain.utils.CatalogoUtils;
import br.edu.infnet.catalogo.rest.dtos.request.CategoriaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.CategoriaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.CategoriaResponse;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaServiceImpl implements CategoriaService {

	private static Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	private final CategoriaRepository categoriaRepository;

	private final CategoriaMapper categoriaMapper;

	public MessageResponse salvar(CategoriaRequest categoriaRequest) {

		Categoria categoria = categoriaMapper.toModel(categoriaRequest);
		categoria.setNome(CatalogoUtils.capitalize(categoria.getNome()));
		if (categoriaRepository.findByNome(categoria.getNome()).isPresent()) {
			throw new RegraDeNegocioException(String
					.format("Operação não permitida, já existe uma categoria com o nome %s!", categoria.getNome()));
		}
			
		CategoriaResponse categoriaResponse = categoriaMapper.toResponse(categoriaRepository.save(categoria));
		log.info("Categoria '{}' criada com sucesso!", categoriaResponse.getNome());
		return criarMensagem("Categoria de id %s criada com sucesso!", categoriaResponse.getId());
	}

	public List<CategoriaResponse> obterTodos() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias.stream().map(categoriaMapper::toResponse).collect(Collectors.toList());
	}

	public CategoriaResponse obterPorId(Long id) {
		Categoria categoria = obterOuFalhar(id);
		return categoriaMapper.toResponse(categoria);
	}

	public MessageResponse atualizar(Long id, CategoriaUpdate categoriaUpdate) {
		Categoria categoria = categoriaMapper.toModel(categoriaUpdate);
		categoria.setNome(CatalogoUtils.capitalize(categoria.getNome()));
		Categoria categoriaPorId = obterOuFalhar(id);
		BeanUtils.copyProperties(categoria, categoriaPorId, "id");
		CategoriaResponse categoriaResponse = categoriaMapper.toResponse(categoriaRepository.save(categoriaPorId));
		log.info("Categoria '{}' atualizada com sucesso!", categoriaResponse.getNome());
		return criarMensagem("Categoria de id %s atualizada com sucesso!", categoriaResponse.getId());
	}

	public MessageResponse excluir(Long id) {
		Categoria categoria = obterOuFalhar(id);
		try {
			categoriaRepository.delete(categoria);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("A categoria de id %s não pode ser excluída!", id));
		}
		return criarMensagem("Categoria de id %s foi excluída com sucesso!", id);
	}

	private Categoria obterOuFalhar(Long id) {
		Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("A categoria de id %s não foi encontrada!", id)));
		return categoria;
	}

	private MessageResponse criarMensagem(String mensagem, Long id) {
		return MessageResponse.builder().message(String.format(mensagem, id)).build();
	}

}
