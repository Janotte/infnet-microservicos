package br.edu.infnet.pessoa.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pessoa.domain.entities.Pessoa;
import br.edu.infnet.pessoa.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.pessoa.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.pessoa.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.pessoa.domain.repositories.PessoaRepository;
import br.edu.infnet.pessoa.domain.utils.PessoaUtils;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public List<Pessoa> obterTodos() {
		return pessoaRepository.findAll();
	}

	public Pessoa obterPorId(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (pessoa.isEmpty())
			throw new EntidadeNaoEncontradaException(String.format("A pessoa de id %s não foi encontrada!", id));
		return pessoa.get();
	}

	public Pessoa obterPorCpfCnpj(String cpfCnpj) {
		Optional<Pessoa> pessoa = pessoaRepository.findByCpfCnpj(cpfCnpj);
		if (pessoa.isEmpty())
			throw new EntidadeNaoEncontradaException(
					String.format("A pessoa de CPF/CNPJ %s não foi encontrada!", cpfCnpj));
		return pessoa.get();
	}

	public Pessoa salvar(Pessoa pessoa) {
		formatPessoa(pessoa);
		if (pessoaRepository.findByCpfCnpj(pessoa.getCpfCnpj()).isPresent())
			throw new RegraDeNegocioException(String
					.format("Operação não permitida, já existe uma pessoa com CPF/CNPJ %s!", pessoa.getCpfCnpj()));
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		formatPessoa(pessoa);
		Pessoa pessoaPorId = obterPorId(id);
		BeanUtils.copyProperties(pessoa, pessoaPorId, "id");
		return pessoaRepository.save(pessoaPorId);
	}

	public void excluir(Long id) {
		try {
			pessoaRepository.delete(obterPorId(id));
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("A pessoa de id %s não pode ser excluíd!", id));
		}
	}

	private void formatPessoa(Pessoa pessoa) {
		pessoa.setNome(PessoaUtils.capitalize(pessoa.getNome()));
		pessoa.setCpfCnpj(PessoaUtils.formatCpfCnpj(pessoa.getCpfCnpj()));
		pessoa.setCelular(PessoaUtils.formatCelular(pessoa.getCelular()));
		pessoa.setEmail(PessoaUtils.makeLowerCase(pessoa.getEmail()));
		pessoa.getEndereco().setCep(PessoaUtils.formatCep(pessoa.getEndereco().getCep()));
		pessoa.getEndereco().setLogradouro(PessoaUtils.capitalize(pessoa.getEndereco().getLogradouro()));
		pessoa.getEndereco().setComplemento(PessoaUtils.capitalize(pessoa.getEndereco().getComplemento()));
		pessoa.getEndereco().setBairro(PessoaUtils.capitalize(pessoa.getEndereco().getBairro()));
		pessoa.getEndereco().setCidade(PessoaUtils.capitalize(pessoa.getEndereco().getCidade()));
		pessoa.getEndereco().setUf(PessoaUtils.makeUpperCase(pessoa.getEndereco().getUf()));
	}

}
