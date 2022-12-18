package br.edu.infnet.catalogo.core.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.infnet.catalogo.domain.entities.Categoria;
import br.edu.infnet.catalogo.rest.dtos.request.CategoriaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.CategoriaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.CategoriaResponse;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

	@Mapping(target = "id", ignore = true)
	Categoria toModel(CategoriaRequest categoriaRequest);
	
	Categoria toModel(CategoriaUpdate categoriaUpdate);
	
	@InheritInverseConfiguration
	CategoriaResponse toResponse(Categoria categoria);
}
