package br.edu.infnet.ordem.rest.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

	private Long id;

	private String nome;

	private String email;

}