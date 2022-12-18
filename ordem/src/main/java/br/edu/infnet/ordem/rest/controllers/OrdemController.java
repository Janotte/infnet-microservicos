package br.edu.infnet.ordem.rest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.ordem.domain.services.OrdemService;
import br.edu.infnet.ordem.rest.dtos.request.OrdemRequest;
import br.edu.infnet.ordem.rest.dtos.request.OrdemUpdate;
import br.edu.infnet.ordem.rest.dtos.response.MessageResponse;
import br.edu.infnet.ordem.rest.dtos.response.OrdemDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ordens")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrdemController {

	private static Logger log = LoggerFactory.getLogger(OrdemController.class);

	private final OrdemService ordemService;

	@PostMapping
	public ResponseEntity<MessageResponse> criarOrdem(@RequestBody OrdemRequest ordemRequest) {
		log.info("Criando uma nova ordem de serviço...");
		return new ResponseEntity<>(ordemService.salvar(ordemRequest), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<OrdemDto>> obterTodasOrdens() {
		log.info("Buscando as Ordens de Serviço...");
		return new ResponseEntity<>(ordemService.obterTodas(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemDto> obterOrdemPorId(@PathVariable(value = "id") Long id) {
		log.info("Buscando a Ordem de Serviço de id {}...", id);
		return new ResponseEntity<>(ordemService.obterPorId(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> atualizarOrdem(@PathVariable(value = "id") Long id,
			@RequestBody OrdemUpdate ordemUpdate) {
		log.info("Atualizando a Ordem de Serviço de id {}...", id);
		return new ResponseEntity<>(ordemService.atualizar(id, ordemUpdate), HttpStatus.OK);
	}
}
