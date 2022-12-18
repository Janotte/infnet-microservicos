package br.edu.infnet.pessoa.rest.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pessoa.domain.services.PessoaService;
import br.edu.infnet.pessoa.rest.dtos.MessageResponse;
import br.edu.infnet.pessoa.rest.dtos.PessoaRequest;
import br.edu.infnet.pessoa.rest.dtos.PessoaResponse;
import br.edu.infnet.pessoa.rest.dtos.PessoaUpdate;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

	private static Logger log = LoggerFactory.getLogger(PessoaController.class);
	
	private final PessoaService pessoaService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<MessageResponse> criarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
		log.info("Criando uma nova Pessoa...");
		return new ResponseEntity<>(pessoaService.salvar(pessoaRequest), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<PessoaResponse>> obterTodasPessoas() {
		log.info("Buscando as Pessoas...");
		return new ResponseEntity<>(pessoaService.obterTodas(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaResponse> obterPessoaPorId(@PathVariable Long id) {
		log.info("Buscando a Pessoa de id {}...", id);
		return new ResponseEntity<>(pessoaService.obterPorId(id), HttpStatus.OK);
	}
	
	@GetMapping("/cpf-cnpj/{cpfCnpj}")
	public ResponseEntity<PessoaResponse> obterPessoaPorCpfCnpj(@PathVariable String cpfCnpj) {
		log.info("Buscando a Pessoa de CPF ou CNPJ {}...", cpfCnpj);
		return new ResponseEntity<>(pessoaService.obterPorCpfCnpj(cpfCnpj), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MessageResponse> atualizarPessoa(@Valid @PathVariable Long id,
			@RequestBody PessoaUpdate pessoaUpdate) {
		log.info("Atualizando a Pessoa de id {}...", id);
		return new ResponseEntity<>(pessoaService.atualizar(id, pessoaUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> excluirPessoa(@PathVariable Long id) {
		log.info("Excluindo a Pessoa de id {}...", id);
		return new ResponseEntity<>(pessoaService.excluir(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/ativa")
	public ResponseEntity<MessageResponse> ativarPessoa(@PathVariable Long id) {
		log.info("Ativando a Pessoa de id {}...", id);
		return new ResponseEntity<>(pessoaService.ativar(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}/inativa")
	public ResponseEntity<MessageResponse> inativarPessoa(@PathVariable Long id) {
		log.info("Inativando a Pessoa de id {}...", id);
		return new ResponseEntity<>(pessoaService.inativar(id), HttpStatus.OK);
	}
}
