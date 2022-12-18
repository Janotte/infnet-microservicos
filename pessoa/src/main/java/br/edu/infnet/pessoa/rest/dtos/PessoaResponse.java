package br.edu.infnet.pessoa.rest.dtos;

import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.infnet.pessoa.domain.entities.TipoPessoa;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de uma nova pessoa.")
@Getter
@Setter
public class PessoaResponse {

	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	private String cpfCnpj;

	private String nome;

	@Embedded
	private EnderecoDto endereco;

	private String email;

	private String celular;

	private Boolean ativo;

	private OffsetDateTime dataRegistro;

	private OffsetDateTime dataAtualizacao;

}
