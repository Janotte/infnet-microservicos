package br.edu.infnet.pessoa.domain.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	@Column(name = "cpf_cnpj", length = 20, nullable = false, unique = true)
	private String cpfCnpj;

	@Column(length = 60, nullable = false)
	private String nome;

	@Embedded
	private Endereco endereco;

	@Column(length = 50)
	private String email;

	@Column(length = 20)
	private String celular;

	private Boolean ativo;

	@CreationTimestamp
	@Column(name = "data_registro")
	private OffsetDateTime dataRegistro;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime dataAtualizacao;

	public void ativar() {
		setAtivo(true);
	}

	public void inativar() {
		setAtivo(false);
	}
}
