package br.edu.infnet.ordem.rest.dtos;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private CategoriaDTO categoria;
	private MedidaDTO medida;
	private Double valor;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String nome, CategoriaDTO categoria, MedidaDTO medida, Double valor) {
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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public MedidaDTO getMedida() {
		return medida;
	}

	public void setMedida(MedidaDTO medida) {
		this.medida = medida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
