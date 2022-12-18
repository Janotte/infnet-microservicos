package br.edu.infnet.ordem.rest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

	private String cep;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String uf;
}
