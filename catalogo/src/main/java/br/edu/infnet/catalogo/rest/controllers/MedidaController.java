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

import br.edu.infnet.catalogo.domain.services.MedidaService;
import br.edu.infnet.catalogo.rest.dtos.request.MedidaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.MedidaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.MedidaResponse;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/medidas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedidaController {

	private static Logger log = LoggerFactory.getLogger(MedidaController.class);

	private final MedidaService medidaService;

	@PostMapping
	public ResponseEntity<MessageResponse> criarMedida(@Valid @RequestBody MedidaRequest medidaRequest) {
		log.info("Criando uma nova Medida...");
		return new ResponseEntity<>(medidaService.salvar(medidaRequest), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<MedidaResponse>> obterTodasMedidas() {
		log.info("Buscando as Medidas...");
		return new ResponseEntity<>(medidaService.obterTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedidaResponse> obterMedidaPorId(@PathVariable Long id) {
		log.info("Buscando a Medida de id {}...", id);
		return new ResponseEntity<>(medidaService.obterPorId(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> atualizarMedida(@Valid @PathVariable Long id, @RequestBody MedidaUpdate medidaUpdate) {
		log.info("Atualizando a Medida de id {}...", id);
		return new ResponseEntity<>(medidaService.atualizar(id, medidaUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> excluirMedida(@PathVariable Long id) {
		log.info("Excluindo a Medida de id {}...", id);
		return new ResponseEntity<>(medidaService.excluir(id), HttpStatus.OK);
	}
}
