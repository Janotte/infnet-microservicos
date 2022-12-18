package br.edu.infnet.catalogo.rest.dtos.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponse {

	@ApiModelProperty(notes = "Identificador único do produto.", example = "1", required = true, position = 0)
	private Long id;

	@ApiModelProperty(notes = "Nome do produto.", example = "SSD 480Gb NVME Corsair 7000", required = true, position = 1)
	private String nome;

	private CategoriaResponse categoria;

	private MedidaResponse medida;

	@ApiModelProperty(notes = "Valor do produto.", example = "1", required = true, position = 3)
	private Double valor;
}
