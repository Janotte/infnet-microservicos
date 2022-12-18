package br.edu.infnet.ordem.rest.dtos.request;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.infnet.ordem.domain.entities.LocalAtendimento;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemRequest {

	@ApiModelProperty(notes = "Local de atendimento pode ser Interno, externo ou remoto.", example = "REMOTO", required = true, position = 0)
	@NotNull(message = "O local de atendimento é necessário.")
	private LocalAtendimento localAtendimento;

	@ApiModelProperty(notes = "Id do usuário.", example = "1", required = true, position = 1)
	@NotNull(message = "O id do usuário é necessário.")
	@Enumerated(EnumType.STRING)
	private Long usuarioId;

	@ApiModelProperty(notes = "Id do cliente.", example = "1", required = true, position = 2)
	@NotNull(message = "O id do cliente é necessário.")
	private Long clienteId;

	@ApiModelProperty(notes = "Descrição do equipamento.", example = "Notebook Dell Inspiron 15", required = true, position = 3)
	@NotBlank(message = "O objeto é necessário")
	@Size(max = 60, message = "Pode conter no máximo 60 caracteres.")
	private String objeto;

	@ApiModelProperty(notes = "Número de série do equipamento.", example = "1GXB45H-001", position = 4)
	@Size(max = 30, message = "Pode conter no máximo 30 caracteres.")
	private String serial;

	@ApiModelProperty(notes = "Setor onde está o equipamento.", example = "Administrativo", position = 5)
	@Size(max = 30, message = "Pode conter no máximo 30 caracteres.")
	private String setor;

	@ApiModelProperty(notes = "Nome do utilizador do equipamento.", example = "Luis Camargo", position = 6)
	@Size(max = 30, message = "Pode conter no máximo 30 caracteres.")
	private String utilizador;

	@ApiModelProperty(notes = "Descrição da solicitação ou problema do equipamento.", example = "Não carrega o Windows", required = true, position = 7)
	@NotBlank(message = "A solicitação é necessária")
	@Size(max = 250, message = "Pode conter no máximo 250 caracteres.")
	private String solicitacao;

	@ApiModelProperty(notes = "Descrição do diagnostico realizado pelo técnico.", example = "HD com blocos ruins, necessária a troca", position = 8)
	@Size(max = 250, message = "Pode conter no máximo 250 caracteres.")
	private String diagnostico;

	@ApiModelProperty(notes = "Descrição da solução para o problema apresentado.", example = "Backup, troca do HD por SSD e reinstalação do Windows", position = 9)
	@Size(max = 250, message = "Pode conter no máximo 250 caracteres.")
	private String solucao;

	private List<ItemProdutoRequest> produtos;
}
