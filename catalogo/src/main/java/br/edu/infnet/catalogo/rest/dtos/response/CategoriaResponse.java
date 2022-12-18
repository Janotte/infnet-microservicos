package br.edu.infnet.catalogo.rest.dtos.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaResponse {

	@ApiModelProperty(notes = "Identificador único da cataegoria.", example = "1", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Nome da categoria.", example = "Armanenamento", position = 1)
	private String nome;

	@ApiModelProperty(notes = "Descrição da categoria.", example = "Incluir nesta categoria HDs, SSDs e Pendrives", position = 1)
	private String descricao;
}
