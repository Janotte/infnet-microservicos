package br.edu.infnet.ordem.rest.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {

	private Long id;

	private String nome;

	private CategoriaRequest categoria;

	private MedidaRequest medida;

	private Double valor;
}
