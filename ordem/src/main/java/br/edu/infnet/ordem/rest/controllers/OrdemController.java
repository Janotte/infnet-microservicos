package br.edu.infnet.ordem.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.ordem.domain.entities.Ordem;
import br.edu.infnet.ordem.domain.services.OrdemService;

@RestController
@RequestMapping("/ordens")
public class OrdemController {

	@Autowired
	private OrdemService ordemService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ordem abrirOrdem(@RequestBody Ordem ordem) {
		return ordemService.salvar(ordem);
	}
}
