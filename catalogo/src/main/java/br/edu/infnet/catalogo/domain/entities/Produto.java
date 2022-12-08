package br.edu.infnet.catalogo.domain.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, nullable = false, unique = true)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "catagoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "medida_id")
	private Medida medida;
	
	@Column(nullable = false)
	private Double valor;

	public Produto() {
		super();
	}

	public Produto(Long id, String nome, Categoria categoria, Medida medida, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.medida = medida;
		this.valor = valor;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", medida=" + medida + ", valor="
				+ valor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
			
}
