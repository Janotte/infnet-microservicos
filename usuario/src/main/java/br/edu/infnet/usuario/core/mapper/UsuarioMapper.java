package br.edu.infnet.usuario.core.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.infnet.usuario.domain.entities.Usuario;
import br.edu.infnet.usuario.rest.dtos.UsuarioRequest;
import br.edu.infnet.usuario.rest.dtos.UsuarioResponse;
import br.edu.infnet.usuario.rest.dtos.UsuarioUpdate;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "ativo", ignore = true)
	@Mapping(target = "dataRegistro", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	Usuario toModel(UsuarioRequest usuarioRequest);

	Usuario toModel(UsuarioUpdate usuarioUpdate);
	
	@InheritInverseConfiguration
	UsuarioResponse toResponse(Usuario usuario);
}
