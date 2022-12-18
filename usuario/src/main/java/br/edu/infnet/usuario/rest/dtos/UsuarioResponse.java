package br.edu.infnet.usuario.rest.dtos;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação do usuário na resposta da aplicação.")
@Getter
@Setter
public class UsuarioResponse {

	@ApiModelProperty(notes = "Identificador único do usuário.", example = "1", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Nome do usuário.", example = "João da Silva Andrade", position = 1)
	private String nome;

	@ApiModelProperty(notes = "E-mail do usuário.", example = "jsilva@email.com.be", position = 2)
	private String email;

	@ApiModelProperty(notes = "Status do usuário.", position = 4)
	private Boolean ativo;

	@ApiModelProperty(notes = "Data de criação do usuário.", position = 5)
	private OffsetDateTime dataRegistro;

	@ApiModelProperty(notes = "Data de última atualização do usuário.", position = 6)
	private OffsetDateTime dataAtualizacao;

}
