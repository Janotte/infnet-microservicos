package br.edu.infnet.catalogo.rest.dtos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedidaRequest {

	@ApiModelProperty(notes = "Nome da medida.", example = "Unidade", required = true, position = 1)
	@NotBlank(message = "O nome é necessário.")
	@Size(max = 30, message = "Pode conter no máximo 30 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "Sigla da medida.", example = "Un", required = true, position = 1)
	@NotBlank(message = "A sigla é necessária.")
	@Size(max = 3, message = "Pode conter no máximo 3 caracteres.")
	private String sigla;
}
