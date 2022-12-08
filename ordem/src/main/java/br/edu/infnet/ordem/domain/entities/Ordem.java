package br.edu.infnet.ordem.domain.entities;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@Entity
public class Ordem {

	@Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "local_atendimento")
	private LocalAtendimento localAtendimento;

	private Situacao situacao;

	@Column(name = "usuario_id")
	private Long usuarioId;

	@Column(name = "pessoa_id")
	private Long clienteId;

	private String objeto;

	private String marca;

	private String serial;

	private String setor;

	private String utilizador;

	private String solicitacao;

	private String diagnostico;

	private String solucao;

	@OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemProduto> produtos;

	@CreationTimestamp
	@Column(name = "data_registro")
	private OffsetDateTime dataRegistro;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime dataAtualizacao;

	public Ordem(Long id, LocalAtendimento localAtendimento, Situacao situacao, Long usuarioId, Long clienteId,
			String objeto, String marca, String serial, String setor, String utilizador, String solicitacao,
			String diagnostico, String solucao, List<ItemProduto> produtos, OffsetDateTime dataRegistro,
			OffsetDateTime dataAtualizacao) {
		super();
		this.id = id;
		this.localAtendimento = localAtendimento;
		this.situacao = situacao;
		this.usuarioId = usuarioId;
		this.clienteId = clienteId;
		this.objeto = objeto;
		this.marca = marca;
		this.serial = serial;
		this.setor = setor;
		this.utilizador = utilizador;
		this.solicitacao = solicitacao;
		this.diagnostico = diagnostico;
		this.solucao = solucao;
		this.produtos = produtos;
		this.dataRegistro = dataRegistro;
		this.dataAtualizacao = dataAtualizacao;
	}

}
