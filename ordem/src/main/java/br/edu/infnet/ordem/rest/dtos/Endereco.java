package br.edu.infnet.ordem.rest.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de endereço.")
@Getter
@Setter
public class Endereco {

	@ApiModelProperty(notes = "Cep do local.", example = "90.450-120")
	private String cep;
	
	@ApiModelProperty(notes = "Nome ou número do Logradouro.", example = "Rua Carlos Trein Filho")
	private String logradouro;
	
	@ApiModelProperty(notes = "Número do local.", example = "888")
	private String numero;
	
	@ApiModelProperty(notes = "Complemento de endereço.", example = "Apto 702")
	private String complemento;
	
	@ApiModelProperty(notes = "Nome do bairro.", example = "Auxiliadora")
	private String bairro;
	
	@ApiModelProperty(notes = "Nome da cidade.", example = "Rio Grande do Sul")
	private String cidade;
	
	@ApiModelProperty(notes = "Sigla do estado.", example = "RS")
	private String uf;
}
