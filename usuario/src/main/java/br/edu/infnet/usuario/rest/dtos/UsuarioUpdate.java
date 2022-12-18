package br.edu.infnet.usuario.rest.dtos;

import java.time.OffsetDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação do usuário de atualização da aplicação.")
@Getter
@Setter
public class UsuarioUpdate {

	@ApiModelProperty(notes = "Identificador único do usuário.", example = "1", required = true, position = 0)
	@NotNull(message = "O id é necessário.")
	private Long id;

	@ApiModelProperty(notes = "Nome do usuário.", example = "João da Silva Andrade", required = true, position = 1)
	@NotBlank(message = "O nome é necessário.")
	@Size(max = 60, message = "Pode conter no máximo 60 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "E-mail do usuário.", example = "jsilva@email.com.be", required = true, position = 2)
	@Email(message = "Deve ser um email válido.")
	@NotBlank(message = "O email é necessário.")
	private String email;

	@ApiModelProperty(notes = "Senha do usuário.", example = "SenhaDoUsuario.123", required = true, position = 3)
	@NotBlank(message = "A senha é necessária.")
	private String senha;

	@ApiModelProperty(notes = "Status do usuário.", position = 4)
	private Boolean ativo;

	@ApiModelProperty(notes = "Data de criação do usuário.", position = 5)
	private OffsetDateTime dataRegistro;

	@ApiModelProperty(notes = "Data de última atualização do usuário.", position = 6)
	private OffsetDateTime dataAtualizacao;

}
