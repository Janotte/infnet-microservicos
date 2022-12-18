package br.edu.infnet.ordem.rest.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de produto.")
@Getter
@Setter
public class ProdutoRequest {

	@ApiModelProperty(notes = "Identificador único do Produto.", example = "1", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Nome do produto.", example = "SSD 480Gb NVME Corsair 7000", position = 1)
	private String nome;

	@ApiModelProperty(notes = "Categoria do produto.", example = "1", position = 1)
	private CategoriaRequest categoria;

	@ApiModelProperty(notes = "Medida do produto.", example = "1", position = 2)
	private MedidaRequest medida;

	@ApiModelProperty(notes = "Valor do produto.", example = "399.99", position = 3)
	private Double valor;
}
