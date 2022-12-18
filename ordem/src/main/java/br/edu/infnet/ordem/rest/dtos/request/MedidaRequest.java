package br.edu.infnet.ordem.rest.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedidaRequest {
	
	private Long id;

	private String nome;
	
	private String sigla;

}
