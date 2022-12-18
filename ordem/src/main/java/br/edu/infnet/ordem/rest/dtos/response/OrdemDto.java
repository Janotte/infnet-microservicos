package br.edu.infnet.ordem.rest.dtos.response;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.infnet.ordem.domain.entities.LocalAtendimento;
import br.edu.infnet.ordem.domain.entities.Situacao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Classe de representação de resposta de ordem de serviço.")
@Getter
@Setter
public class OrdemDto {

	@ApiModelProperty(notes = "Identificador único da ordem de serviço.", example = "59871", position = 0)
	private Long id;

	@ApiModelProperty(notes = "Situação da ordem de serviço, ABERTA, ANALISE, CONCLUIDA ou CANCELADA.", example = "ABERTA", required = true, position = 1)
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@ApiModelProperty(notes = "Local de atendimento pode ser Interno, externo ou remoto.", example = "REMOTO", position = 2)
	@Enumerated(EnumType.STRING)
	private LocalAtendimento localAtendimento;

	@NotNull(message = "O id do usuário é necessário.")
	private UsuarioResponse usuario;

	@NotNull(message = "O id do cliente é necessário.")
	private PessoaResponse cliente;

	@ApiModelProperty(notes = "Descrição do equipamento.", example = "Notebook Dell Inspiron 15", required = true, position = 5)
	@NotBlank(message = "O objeto é necessário")
	@Size(max = 60, message = "Pode conter no máximo 60 caracteres.")
	private String objeto;

	@ApiModelProperty(notes = "Número de série do equipamento.", example = "1GXB45H-001", position = 6)
	@Size(max = 30, message = "Pode conter no máximo 30 caracteres.")
	private String serial;

	@ApiModelProperty(notes = "Setor onde está o equipamento.", example = "Administrativo", position = 7)
	@Size(max = 30, message = "Pode conter no máximo 30 caracteres.")
	private String setor;

	@ApiModelProperty(notes = "Nome do utilizador do equipamento.", example = "Luis Camargo", position = 8)
	@Size(max = 30, message = "Pode conter no máximo 30 caracteres.")
	private String utilizador;

	@ApiModelProperty(notes = "Descrição da solicitação ou problema do equipamento.", example = "Não carrega o Windows", required = true, position = 9)
	@NotBlank(message = "A solicitação é necessária")
	@Size(max = 250, message = "Pode conter no máximo 250 caracteres.")
	private String solicitacao;

	@ApiModelProperty(notes = "Descrição do diagnostico realizado pelo técnico.", example = "HD com blocos ruins, necessária a troca", position = 10)
	@Size(max = 250, message = "Pode conter no máximo 250 caracteres.")
	private String diagnostico;

	@ApiModelProperty(notes = "Descrição da solução para o problema apresentado.", example = "Backup, troca do HD por SSD e reinstalação do Windows", position = 11)
	@Size(max = 250, message = "Pode conter no máximo 250 caracteres.")
	private String solucao;

	@ApiModelProperty(notes = "Data de registro da ordem de serviço.", example = "15:30:18 12/12/2022", position = 12)
	private OffsetDateTime dataRegistro;

	@ApiModelProperty(notes = "Data da última atualização da ordem de serviço.", example = "17:42:35 12/12/2022", position = 13)
	private OffsetDateTime dataAtualizacao;
	
	private List<ItemProdutoResponse> produtos;


}
