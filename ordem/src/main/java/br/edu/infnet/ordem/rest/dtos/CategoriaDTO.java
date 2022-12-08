package br.edu.infnet.ordem.rest.dtos;

public class CategoriaDTO {

	private Long id;
	private String nome;
	private String descricao;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "CategoriaDTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}