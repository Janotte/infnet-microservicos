package br.edu.infnet.usuario.rest.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@ApiModel(description = "Classe de representação da mensagem de resposta da aplicação.")
@Data
@Builder
public class MessageResponse {

	private String message;
}