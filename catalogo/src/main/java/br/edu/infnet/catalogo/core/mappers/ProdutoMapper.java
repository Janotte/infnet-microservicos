package br.edu.infnet.catalogo.core.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.infnet.catalogo.domain.entities.Produto;
import br.edu.infnet.catalogo.rest.dtos.request.ProdutoRequest;
import br.edu.infnet.catalogo.rest.dtos.request.ProdutoUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.ProdutoResponse;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(source = "categoriaId", target = "categoria.id")
	@Mapping(source = "medidaId", target = "medida.id")
	Produto toModel(ProdutoRequest produtoRequest);

	Produto toModel(ProdutoUpdate produtoUpdate);
	
	@InheritInverseConfiguration
	ProdutoResponse toResponse(Produto produto);
	
}
