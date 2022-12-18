package br.edu.infnet.pessoa.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.infnet.pessoa.domain.entities.Pessoa;
import br.edu.infnet.pessoa.rest.dtos.PessoaRequest;
import br.edu.infnet.pessoa.rest.dtos.PessoaResponse;
import br.edu.infnet.pessoa.rest.dtos.PessoaUpdate;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "ativo", ignore = true)
	@Mapping(target = "dataRegistro", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	Pessoa toModel(PessoaRequest pessoaRequest);
	
	Pessoa toModel(PessoaUpdate pessoaUpdate);
	
	PessoaResponse toResponse(Pessoa pessoa);
}
