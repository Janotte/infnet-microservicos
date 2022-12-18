package br.edu.infnet.pessoa.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CampoInvalidoException(String mensagem) {
		super(mensagem);
	}
}