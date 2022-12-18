package br.edu.infnet.usuario.rest.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de um novo usuário.")
@Getter
@Setter
public class UsuarioRequest {

	@ApiModelProperty(notes = "Nome do usuário.", example = "João da Silva Andrade", required = true, position = 0)
	@NotBlank(message = "O nome é necessário.")
	@Size(max = 60, message = "Pode conter no máximo 60 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "E-mail do usuário.", example = "jsilva@email.com.br", required = true, position = 1)
	@Email(message = "Deve ser um email válido.")
	@NotBlank(message = "O email é necessário.")
	private String email;

	@ApiModelProperty(notes = "Senha do usuário.", example = "SenhaDoUsuario.123", required = true, position = 2)
	@NotBlank(message = "A senha é necessária.")
	private String senha;

}
