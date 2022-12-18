package br.edu.infnet.pessoa.rest.dtos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Embeddable
public class EnderecoDto {

	@ApiModelProperty(notes = "Cep do local.", example = "90.450-120")
	@Size(max = 10, message = "Pode conter no máximo 10 caracteres.")
	private String cep;
	
	@ApiModelProperty(notes = "Nome ou número do Logradouro.", example = "Rua Carlos Trein Filho")
	@Size(max = 60, message = "Pode conter no máximo 60 caracteres.")
	private String logradouro;
	
	@ApiModelProperty(notes = "Número do local.", example = "888")
	@Size(max = 8, message = "Pode conter no máximo 8 caracteres.")
	@Column(name = "endereco_numero", length = 8)
	private String numero;
	
	@ApiModelProperty(notes = "Complemento de endereço.", example = "Apto 702")
	@Size(max = 20, message = "Pode conter no máximo 20 caracteres.")
	private String complemento;
	
	@ApiModelProperty(notes = "Nome do bairro.", example = "Auxiliadora")
	@Size(max = 40, message = "Pode conter no máximo 40 caracteres.")
	private String bairro;
	
	@ApiModelProperty(notes = "Nome da cidade.", example = "Rio Grande do Sul")
	@Size(max = 40, message = "Pode conter no máximo 40 caracteres.")
	private String cidade;
	
	@ApiModelProperty(notes = "Sigla do estado.", example = "RS")
	@Size(max = 2, message = "Pode conter no máximo 2 caracteres.")
	private String uf;
}
