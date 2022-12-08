package br.edu.infnet.ordem.rest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemProdutoDTO {

	private Long id;
	private Long produtoId;
	private Double quantidade;
	private Double valor;
	
}
