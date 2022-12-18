package br.edu.infnet.catalogo.rest.dtos.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedidaResponse {

	@ApiModelProperty(notes = "Identificador único da media.", example = "1", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Nome da medida.", example = "Unidade", position = 1)
	private String nome;

	@ApiModelProperty(notes = "Sigla da medida.", example = "Un", position = 2)
	private String sigla;
}
