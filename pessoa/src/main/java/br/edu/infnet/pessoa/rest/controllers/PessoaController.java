package br.edu.infnet.pessoa.rest.controllers;

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

import br.edu.infnet.pessoa.domain.entities.Pessoa;
import br.edu.infnet.pessoa.domain.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> listarPessoas() {
		return pessoaService.obterTodos();
	}

	@GetMapping("/{id}")
	public Pessoa obterPessoa(@PathVariable Long id) {
		return pessoaService.obterPorId(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return pessoaService.atualizar(id, pessoa);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void excluirPessoa(@PathVariable Long id) {
		pessoaService.excluir(id);
	}
}
