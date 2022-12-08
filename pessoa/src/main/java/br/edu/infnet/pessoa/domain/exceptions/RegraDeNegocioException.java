package br.edu.infnet.pessoa.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RegraDeNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraDeNegocioException(String mensagem) {
		super(mensagem);
	}
}