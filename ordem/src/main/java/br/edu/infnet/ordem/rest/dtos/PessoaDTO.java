package br.edu.infnet.ordem.rest.dtos;

import java.time.OffsetDateTime;

import br.edu.infnet.ordem.domain.entities.TipoPessoa;

public class PessoaDTO {

	private Long id;
	private TipoPessoa tipoPessoa;
	private String cpfCnpj;
	private String nome;
	private EnderecoDTO endereco;
	private String email;
	private String celular;
	private OffsetDateTime dataRegistro;
	private OffsetDateTime dataAtualizacao;

	public PessoaDTO() {
	}

	public PessoaDTO(Long id, TipoPessoa tipoPessoa, String cpfCnpj, String nome, EnderecoDTO endereco, String email,
			String celular, OffsetDateTime dataRegistro, OffsetDateTime dataAtualizacao) {
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
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

}