package br.edu.infnet.catalogo.core.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.edu.infnet.catalogo.domain.entities.Medida;
import br.edu.infnet.catalogo.rest.dtos.request.MedidaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.MedidaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.MedidaResponse;

@Mapper(componentModel = "spring")
public interface MedidaMapper {

	@Mapping(target = "id", ignore = true)
	Medida toModel(MedidaRequest medidaRequest);
	
	Medida toModel(MedidaUpdate medidaUpdate);

	MedidaResponse toResponse(Medida medida);
}
