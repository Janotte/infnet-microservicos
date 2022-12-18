package br.edu.infnet.ordem.core.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.edu.infnet.ordem.domain.entities.ItemProduto;
import br.edu.infnet.ordem.domain.entities.Ordem;
import br.edu.infnet.ordem.rest.dtos.request.ItemProdutoRequest;
import br.edu.infnet.ordem.rest.dtos.request.ItemProdutoUpdate;
import br.edu.infnet.ordem.rest.dtos.request.OrdemRequest;
import br.edu.infnet.ordem.rest.dtos.request.OrdemUpdate;
import br.edu.infnet.ordem.rest.dtos.response.ItemProdutoResponse;
import br.edu.infnet.ordem.rest.dtos.response.OrdemResponse;

@Mapper(componentModel = "spring")
public interface OrdemMapper {

	OrdemMapper INSTANCE = Mappers.getMapper(OrdemMapper.class);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "dataRegistro", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "situacao", ignore = true)
	Ordem toModel(OrdemRequest ordemRequest);

	Ordem toOrdem(OrdemUpdate ordemUpdate);
	
	@InheritInverseConfiguration
	OrdemResponse toResponse(Ordem ordem);
	
	@Mapping(target = "ordem", ignore = true)
	@Mapping(target = "valor", ignore = true)
	@Mapping(target = "id", ignore = true)
	ItemProduto toModel(ItemProdutoRequest itemProdutoRequest);
	
	ItemProdutoResponse toResponse(ItemProduto itemProduto);
	
	List<ItemProdutoResponse> toResponseList(List<ItemProduto> itemProdutoList);
	
	@Mapping(target = "ordem", ignore = true)
	ItemProduto toModel(ItemProdutoUpdate itemProdutoUpdate);
	
	List<ItemProduto> toModelList(List<ItemProdutoUpdate> itemProdutoUpdates);
	
}
