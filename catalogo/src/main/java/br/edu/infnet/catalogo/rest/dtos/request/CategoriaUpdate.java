package br.edu.infnet.catalogo.rest.dtos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaUpdate {

	@ApiModelProperty(notes = "Identificador único da categoria.", example = "1", required = true, position = 0)
	@NotNull(message = "O id é necessário.")
	private Long id;
	
	@ApiModelProperty(notes = "Nome da categoria.", example = "Armanenamento", required = true, position = 1)
	@NotBlank
	@Size(max = 60, message = "Pode conter no máximo 60 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "Descrição da categoria.", example = "Incluir nesta categoria HDs, SSDs e Pendrives", position = 1)
	private String descricao;
}
