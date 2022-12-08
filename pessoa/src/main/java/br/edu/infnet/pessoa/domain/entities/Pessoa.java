package br.edu.infnet.pessoa.domain.entities;

import java.time.OffsetDateTime;
import java.util.Objects;

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

@Entity
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

	@CreationTimestamp
	@Column(name = "data_registro")
	private OffsetDateTime dataRegistro;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime dataAtualizacao;

	public Pessoa() {
		super();
	}

	public Pessoa(Long id, TipoPessoa tipoPessoa, String cpfCnpj, String nome, Endereco endereco, String email,
			String celular, OffsetDateTime dataRegistro, OffsetDateTime dataAtualizacao) {
		super();
		this.id = id;
		this.tipoPessoa = tipoPessoa;
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.celular = celular;
		this.dataRegistro = dataRegistro;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}

	public OffsetDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", tipoPessoa=" + tipoPessoa + ", cpfCnpj=" + cpfCnpj + ", nome=" + nome
				+ ", endereco=" + endereco + ", email=" + email + ", celular=" + celular + ", dataRegistro="
				+ dataRegistro + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
}
