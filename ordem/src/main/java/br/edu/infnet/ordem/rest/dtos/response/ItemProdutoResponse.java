package br.edu.infnet.ordem.rest.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de resposta de item de produto.")
@Getter
@Setter
public class ItemProdutoResponse {

	@ApiModelProperty(notes = "Id do item de produto.", example = "1", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Id do produto.", example = "1", position = 1)
	private Long produtoId;

	@ApiModelProperty(notes = "Quantidade do produto para incluir no item.", example = "2", position = 2)
	private Double quantidade;

	@ApiModelProperty(notes = "valor do item de produto.", example = "199.16", position = 3)
	private Double valor;

}
