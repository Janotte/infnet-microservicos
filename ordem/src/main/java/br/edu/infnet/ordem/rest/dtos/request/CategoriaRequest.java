package br.edu.infnet.ordem.rest.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de categoria.")
@Getter
@Setter
public class CategoriaRequest {

	@ApiModelProperty(notes = "Identificador único da Categoria.", example = "1", required = true, position = 0)
	private Long id;

	@ApiModelProperty(notes = "Nome da Categoria.", example = "Armazenamento", position = 1)
	private String nome;
	
	@ApiModelProperty(notes = "Descrição da Categoria.", example = "Hds, SSDs, e Pendrives", position = 2)
	private String descricao;
}
