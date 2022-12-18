package br.edu.infnet.pessoa.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pessoa.core.mapper.PessoaMapper;
import br.edu.infnet.pessoa.domain.entities.Pessoa;
import br.edu.infnet.pessoa.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.pessoa.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.pessoa.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.pessoa.domain.repositories.PessoaRepository;
import br.edu.infnet.pessoa.domain.utils.PessoaUtils;
import br.edu.infnet.pessoa.rest.dtos.MessageResponse;
import br.edu.infnet.pessoa.rest.dtos.PessoaRequest;
import br.edu.infnet.pessoa.rest.dtos.PessoaResponse;
import br.edu.infnet.pessoa.rest.dtos.PessoaUpdate;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaServiceImpl implements PessoaService {

	private final PessoaRepository pessoaRepository;

	private final PessoaMapper mapper;

	@Transactional
	public MessageResponse salvar(PessoaRequest pessoaRequest) {
		Pessoa pessoa = mapper.toModel(pessoaRequest);
		pessoa.setAtivo(true);
		formatPessoa(pessoa);
		if (pessoaRepository.findByCpfCnpj(pessoa.getCpfCnpj()).isPresent())
			throw new RegraDeNegocioException(String
					.format("Operação não permitida, já existe uma pessoa com CPF/CNPJ %s!", pessoa.getCpfCnpj()));
		PessoaResponse pessoaResponse = mapper.toResponse(pessoaRepository.save(pessoa));
		return criarMensagemDTO("Pessoa de id %s criada com sucesso!", pessoaResponse.getId());
	}

	public List<PessoaResponse> obterTodas() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		return pessoas.stream().map(mapper::toResponse).collect(Collectors.toList());
	}

	public PessoaResponse obterPorId(Long id) {
		Pessoa pessoa = obterOuFalhar(id);
		return mapper.toResponse(pessoa);
	}

	public PessoaResponse obterPorCpfCnpj(String cpfCnpj) {
		Pessoa pessoa = pessoaRepository.findByCpfCnpj(PessoaUtils.formatCpfCnpj(cpfCnpj)).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("A pessoa de CPF/CNPJ %s não foi encontrada!", cpfCnpj)));
		return mapper.toResponse(pessoa);
	}

	@Transactional
	public MessageResponse atualizar(Long id, PessoaUpdate pessoaUpdate) {
		Pessoa pessoa = mapper.toModel(pessoaUpdate);
		formatPessoa(pessoa);
		Pessoa pessoaPorId = obterOuFalhar(id);
		BeanUtils.copyProperties(pessoa, pessoaPorId,  "id", "dataRegistro", "dataAtualizacao");
		Pessoa pessoaSalva = pessoaRepository.save(pessoaPorId);
		return criarMensagemDTO("Usuário de id %s atualizado com sucesso!", pessoaSalva.getId());
	}

	@Transactional
	public MessageResponse excluir(Long id) {
		Pessoa pessoa = obterOuFalhar(id);
		try {
			pessoaRepository.delete(pessoa);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("A pessoa de id %s não pode ser excluída!", id));
		}
		return criarMensagemDTO("Pessoa de id %s excluída com sucesso!", id);
	}

	@Transactional
	public MessageResponse ativar(Long id) {
		Pessoa pessoa = obterOuFalhar(id);
		pessoa.ativar();
		pessoaRepository.save(pessoa);
		return criarMensagemDTO("Pessoa de id %s ativada com sucesso!", id);
	}

	@Transactional
	public MessageResponse inativar(Long id) {
		Pessoa pessoa = obterOuFalhar(id);
		pessoa.inativar();
		pessoaRepository.save(pessoa);
		return criarMensagemDTO("Pessoa de id %s inativada com sucesso!", id);
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

	private Pessoa obterOuFalhar(Long id) {
		Pessoa pessoaPorId = pessoaRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format("A pessoa de id %s não foi encontrada!", id)));
		return pessoaPorId;
	}

	private MessageResponse criarMensagemDTO(String mensagem, Long id) {
		return MessageResponse.builder().message(String.format(mensagem, id)).build();
	}

}
