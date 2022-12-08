package br.edu.infnet.catalogo.domain.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String nome;
	
	@Column(length = 3, nullable = false, unique = true)
	private String sigla;
	
	public Medida() {
		super();
	}
	
	public Medida(Long id, String nome, String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Medida [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medida other = (Medida) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(sigla, other.sigla);
	}
	
}
