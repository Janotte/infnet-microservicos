package br.edu.infnet.pessoa.rest.dtos;

import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.edu.infnet.pessoa.domain.entities.TipoPessoa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação da pessoa de atualização da aplicação.")
@Getter
@Setter
public class PessoaUpdate {

	@ApiModelProperty(notes = "Identificador único do usuário.", example = "1", position = 0)
	private Long id;
	
	@ApiModelProperty(notes = "Tipo de pessoa, física ou jurídica.", example = "FISICA", required = true, position = 1)
	@NotBlank(message = "O tipo de pessoa é necessário.")
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	@ApiModelProperty(notes = "CPF ou CNPJ da pessoa", example = "111.111.111.11", required = true, position = 2)
	@NotBlank(message = "O CPF ou CNPJ é necessário.")
	@Size(max = 20, message = "Pode conter no máximo 20 caracteres.")
	private String cpfCnpj;

	@ApiModelProperty(notes = "Nome da pessoa.", example = "João da Silva Andrade", required = true, position = 3)
	@NotBlank(message = "O nome é necessário.")
	@Size(max = 60)
	private String nome;

	@Embedded
	private EnderecoDto endereco;

	@ApiModelProperty(notes = "E-mail da pessoa.", example = "jsilva@email.com.br", required = true, position = 4)
	@Email(message = "Deve ser um email válido.")
	@NotBlank(message = "O email é necessário.")
	private String email;

	@ApiModelProperty(notes = "Número do celular da pessoa.", example = "47 99999-9999", position = 5)
	@Size(max = 20, message = "Pode conter no máximo 20 caracteres.")
	private String celular;
	
	private Boolean ativo;
	
	private OffsetDateTime dataRegistro;

	private OffsetDateTime dataAtualizacao;

}
