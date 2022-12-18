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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ordem {

	@Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "local_atendimento")
	private LocalAtendimento localAtendimento;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@Column(name = "usuario_id")
	private Long usuarioId;

	@Column(name = "pessoa_id")
	private Long clienteId;

	@Column(nullable = false, length = 60)
	private String objeto;

	@Column(length = 30)
	private String serial;

	@Column(length = 30)
	private String setor;

	@Column(length = 30)
	private String utilizador;

	@Column(length = 250)
	private String solicitacao;

	@Column(length = 250)
	private String diagnostico;

	@Column(length = 250)
	private String solucao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ordem_id")
	private List<ItemProduto> produtos;

	@CreationTimestamp
	@Column(name = "data_registro")
	private OffsetDateTime dataRegistro;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime dataAtualizacao;

}
