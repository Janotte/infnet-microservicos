package br.edu.infnet.catalogo.rest.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.catalogo.domain.entities.Categoria;
import br.edu.infnet.catalogo.domain.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> listarCategorias() {
		return categoriaService.obterTodos();
	}

	@GetMapping("/{id}")
	public Categoria obterCategoria(@PathVariable Long id) {
		return categoriaService.obterPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria salvarCategoria(@RequestBody Categoria categoria) {
		return categoriaService.salvar(categoria);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
		return categoriaService.atualizar(id, categoria);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluirCategoria(@PathVariable Long id) {
		categoriaService.excluir(id);
	}
}
