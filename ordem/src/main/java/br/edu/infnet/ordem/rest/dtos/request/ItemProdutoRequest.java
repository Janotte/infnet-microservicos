package br.edu.infnet.ordem.rest.dtos.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemProdutoRequest {

	@ApiModelProperty(notes = "Id do produto.", example = "1", required = true, position = 0)
	@NotNull(message = "O id do produto é necessário.")
	private Long produtoId;

	@ApiModelProperty(notes = "Quantidade do produto para incluir no item.", example = "2", required = true, position = 1)
	@NotNull(message = "A quantidade de produtos é necessária.")
	private Double quantidade;

}
