package br.edu.infnet.catalogo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.domain.entities.Categoria;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.catalogo.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.catalogo.domain.repositories.CategoriaRepository;
import br.edu.infnet.catalogo.domain.utils.CatalogoUtils;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public List<Categoria> obterTodos() {
		return categoriaRepository.findAll();
	}

	public Categoria obterPorId(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isEmpty())
			throw new EntidadeNaoEncontradaException(String.format("A categoria de id %s não foi encontrada!", id));
		return categoria.get();
	}

	public Categoria salvar(Categoria categoria) {
		categoria.setNome(CatalogoUtils.capitalize(categoria.getNome()));
		if (categoriaRepository.findByNome(categoria.getNome()).isPresent())
			throw new RegraDeNegocioException(String
					.format("Operação não permitida, já existe uma categoria com o nome %s!", categoria.getNome()));
		return categoriaRepository.save(categoria);
	}

	public Categoria atualizar(Long id, Categoria categoria) {
		categoria.setNome(CatalogoUtils.capitalize(categoria.getNome()));
		Categoria categoriaPorId = obterPorId(id);
		BeanUtils.copyProperties(categoria, categoriaPorId, "id");
		return categoriaRepository.save(categoriaPorId);
	}

	public void excluir(Long id) {
		Categoria categoria = obterPorId(id);
		try {
			categoriaRepository.delete(categoria);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("A categoria de id %s não pode ser excluída!", id));
		}
	}

}
