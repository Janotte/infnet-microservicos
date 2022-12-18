package br.edu.infnet.ordem.rest.dtos.response;

import br.edu.infnet.ordem.domain.entities.TipoPessoa;
import br.edu.infnet.ordem.rest.dtos.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de resposta de pessoa.")
@Getter
@Setter
public class PessoaResponse {

	@ApiModelProperty(notes = "Identificador único da pessoa.", example = "59871", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Tipo de pessoa, FISICA ou JURIDICA.", example = "FISICA", position = 1)
	private TipoPessoa tipoPessoa;

	@ApiModelProperty(notes = "CPF ou CNPJ da pessoa", example = "111.111.111.11", position = 2)
	private String cpfCnpj;

	@ApiModelProperty(notes = "Nome da pessoa.", example = "João da Silva Andrade", position = 3)
	private String nome;

	private Endereco endereco;

	@ApiModelProperty(notes = "E-mail da pessoa.", example = "jsilva@email.com.br", position = 4)
	private String email;

	@ApiModelProperty(notes = "Número do celular da pessoa.", example = "47 99999-9999", position = 5)
	private String celular;

}
