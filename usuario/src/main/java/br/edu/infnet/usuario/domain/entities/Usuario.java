package br.edu.infnet.usuario.domain.entities;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private Boolean ativo = Boolean.FALSE;;

	@CreationTimestamp
	@Column(name = "data_registro")
	private OffsetDateTime dataRegistro;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime dataAtualizacao;

	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String senha, Boolean ativo, OffsetDateTime dataRegistro,
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

	public OffsetDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", ativo=" + ativo
				+ ", dataRegistro=" + dataRegistro + ", dataAtualizacao=" + dataAtualizacao + "]";
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
}
