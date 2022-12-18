package br.edu.infnet.catalogo.rest.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.catalogo.domain.services.CategoriaService;
import br.edu.infnet.catalogo.rest.dtos.request.CategoriaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.CategoriaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.CategoriaResponse;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaController {

	private static Logger log = LoggerFactory.getLogger(CategoriaController.class);

	private final CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<MessageResponse> criarCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest) {
		log.info("Criando uma nova Categoria...");
		return new ResponseEntity<>(categoriaService.salvar(categoriaRequest), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaResponse>> obterTodasCategorias() {
		log.info("Buscando as Categorias...");
		return new ResponseEntity<>(categoriaService.obterTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaResponse> obterCategoriaPorId(@PathVariable Long id) {
		log.info("Buscando a Categoria de id {}...", id);
		return new ResponseEntity<>(categoriaService.obterPorId(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> atualizarCategoria(@Valid @PathVariable Long id,
			@RequestBody CategoriaUpdate categoriaUpdate) {
		log.info("Atualizando a Categoria de id {}...", id);
		return new ResponseEntity<>(categoriaService.atualizar(id, categoriaUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> excluirCategoria(@PathVariable Long id) {
		log.info("Excluindo a Categoria de id {}...", id);
		return new ResponseEntity<>(categoriaService.excluir(id), HttpStatus.OK);
	}
}
