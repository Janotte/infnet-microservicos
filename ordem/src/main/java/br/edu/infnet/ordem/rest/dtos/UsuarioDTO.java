package br.edu.infnet.ordem.rest.dtos;

import java.time.OffsetDateTime;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Boolean ativo = Boolean.FALSE;;
	private OffsetDateTime dataRegistro;
	private OffsetDateTime dataAtualizacao;
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String email, String senha, Boolean ativo, OffsetDateTime dataRegistro,
			OffsetDateTime dataAtualizacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
		this.dataRegistro = dataRegistro;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(OffsetDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public OffsetDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", ativo=" + ativo
				+ ", dataRegistro=" + dataRegistro + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
}
