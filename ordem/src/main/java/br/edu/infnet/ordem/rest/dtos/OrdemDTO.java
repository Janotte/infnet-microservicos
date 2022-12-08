package br.edu.infnet.ordem.rest.dtos;

import java.time.OffsetDateTime;
import java.util.List;

import br.edu.infnet.ordem.domain.entities.LocalAtendimento;
import br.edu.infnet.ordem.domain.entities.Situacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemDTO {
	private Long id;
	private LocalAtendimento localAtendimento;
	private Situacao situacao;
	private Long usuarioId;
	private Long clienteId;
	private String objeto;
	private String marca;
	private String serial;
	private String setor;
	private String utilizador;
	private String solicitacao;
	private String diagnostico;
	private String solucao;
	private List<ItemProdutoDTO> produtos;
	private OffsetDateTime dataRegistro;
	private OffsetDateTime dataAtualizacao;
}
