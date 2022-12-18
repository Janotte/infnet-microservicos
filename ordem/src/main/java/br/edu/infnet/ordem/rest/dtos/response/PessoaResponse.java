package br.edu.infnet.ordem.rest.dtos.response;

import br.edu.infnet.ordem.domain.entities.TipoPessoa;
import br.edu.infnet.ordem.rest.dtos.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponse {

	private Long id;

	private TipoPessoa tipoPessoa;

	private String cpfCnpj;

	private String nome;

	private Endereco endereco;

	private String email;

	private String celular;

}
