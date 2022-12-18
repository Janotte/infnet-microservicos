package br.edu.infnet.pessoa.rest.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {

	private String message;
}