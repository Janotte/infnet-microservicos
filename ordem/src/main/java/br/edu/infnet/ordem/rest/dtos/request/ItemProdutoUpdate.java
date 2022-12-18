package br.edu.infnet.ordem.rest.dtos.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de item de produto.")
@Getter
@Setter
public class ItemProdutoUpdate {

	@ApiModelProperty(notes = "Id do item de produto.", example = "1", required = true, position = 0)
	@NotNull(message = "O id do item de produto é necessário.")
	private Long id;
	
	@ApiModelProperty(notes = "Id do produto.", example = "1", required = true, position = 1)
	@NotNull(message = "O id do produto é necessário.")
	private Long produtoId;

	@ApiModelProperty(notes = "Quantidade do produto para incluir no item.", example = "2", required = true, position = 2)
	@NotNull(message = "A quantidade de produtos é necessária.")
	private Double quantidade;

	@ApiModelProperty(notes = "valor do item de produto.", example = "199.16", required = true, position = 3)
	@NotNull(message = "O valor do item de produto é necessário.")
	private Double valor;
}
