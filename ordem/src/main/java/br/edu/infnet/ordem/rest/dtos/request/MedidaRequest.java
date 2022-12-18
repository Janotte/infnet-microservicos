package br.edu.infnet.ordem.rest.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de medida.")
@Getter
@Setter
public class MedidaRequest {
	
	@ApiModelProperty(notes = "Identificador único da Medida.", example = "1", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Nome da Medida.", example = "Unidade", position = 1)
	private String nome;
	
	@ApiModelProperty(notes = "Sigla da Medida.", example = "Un", position = 2)
	private String sigla;

}
