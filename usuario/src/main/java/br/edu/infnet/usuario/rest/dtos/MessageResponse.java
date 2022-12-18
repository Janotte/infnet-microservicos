package br.edu.infnet.usuario.rest.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {

	private String message;
}