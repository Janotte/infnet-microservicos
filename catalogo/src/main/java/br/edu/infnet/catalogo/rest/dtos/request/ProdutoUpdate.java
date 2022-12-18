package br.edu.infnet.catalogo.rest.dtos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoUpdate {

	@ApiModelProperty(notes = "Identificador único do produto.", example = "1", required = true, position = 0)
	@NotNull(message = "O id é necessário.")
	private Long id;

	@ApiModelProperty(notes = "Nome do produto.", example = "SSD 480Gb NVME Corsair 7000", required = true, position = 1)
	@NotBlank(message = "O nome é necessário.")
	@Size(max = 60, message = "Pode conter no máximo 60 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "Categoria do produto.", example = "1", required = true, position = 2)
	@NotNull(message = "A categoria é necessária.")
	private CategoriaUpdate categoria;

	@ApiModelProperty(notes = "Medida do produto.", example = "2", required = true, position = 3)
	@NotNull(message = "A medida é necessária.")
	private MedidaUpdate medida;

	@ApiModelProperty(notes = "Medida do produto.", example = "2", required = true, position = 4)
	@NotNull(message = "O valor é necessário.")
	private Double valor;
}
