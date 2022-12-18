package br.edu.infnet.catalogo.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.core.mappers.MedidaMapper;
import br.edu.infnet.catalogo.domain.entities.Medida;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.catalogo.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.catalogo.domain.repositories.MedidaRepository;
import br.edu.infnet.catalogo.domain.utils.CatalogoUtils;
import br.edu.infnet.catalogo.rest.dtos.request.MedidaRequest;
import br.edu.infnet.catalogo.rest.dtos.request.MedidaUpdate;
import br.edu.infnet.catalogo.rest.dtos.response.MedidaResponse;
import br.edu.infnet.catalogo.rest.dtos.response.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedidaServiceImpl implements MedidaService {

	private final MedidaRepository medidaRepository;

	private final MedidaMapper medidaMapper;

	public MessageResponse salvar(MedidaRequest medidaRequest) {
		Medida medida = medidaMapper.toModel(medidaRequest);
		formatMedida(medida);
		if (medidaRepository.findByNome(medida.getNome()).isPresent())
			throw new RegraDeNegocioException(
					String.format("Operação não permitida, já existe uma medida com o nome %s!", medida.getNome()));
		if (medidaRepository.findBySigla(medida.getSigla()).isPresent())
			throw new RegraDeNegocioException(
					String.format("Operação não permitida, já existe uma medida com a sigla %s!", medida.getSigla()));
		MedidaResponse medidaResponse = medidaMapper.toResponse(medidaRepository.save(medida));
		return criarMensagem("Medida de id %s criada com sucesso!", medidaResponse.getId());
	}

	public List<MedidaResponse> obterTodos() {
		List<Medida> medidas = medidaRepository.findAll();
		return medidas.stream().map(medidaMapper::toResponse).collect(Collectors.toList());
	}

	public MedidaResponse obterPorId(Long id) {
		Medida medida = obterOuFalhar(id);
		return medidaMapper.toResponse(medida);
	}

	public MessageResponse atualizar(Long id, MedidaUpdate medidaUpdate) {
		Medida medida = medidaMapper.toModel(medidaUpdate);
		formatMedida(medida);
		Medida medidaPorId = obterOuFalhar(id);
		BeanUtils.copyProperties(medida, medidaPorId, "id");
		MedidaResponse  medidaResponse = medidaMapper.toResponse(medidaRepository.save(medidaPorId));
		return criarMensagem("Medida de id %s atualizada com sucesso!", medidaResponse.getId());
	}

	public MessageResponse excluir(Long id) {
		Medida medida = obterOuFalhar(id);
		try {
			medidaRepository.delete(medida);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("A medida de id %s não pode ser excluída!", id));
		}
		return criarMensagem("Medida de id %s foi excluída com sucesso!", id);
	}

	private void formatMedida(Medida medida) {
		medida.setNome(CatalogoUtils.capitalize(medida.getNome()));
		medida.setSigla(CatalogoUtils.makeUpperCase(medida.getSigla()));
	}

	private MessageResponse criarMensagem(String mensagem, Long id) {
		return MessageResponse.builder().message(String.format(mensagem, id)).build();
	}

	private Medida obterOuFalhar(Long id) {
		Medida medida = medidaRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format("A medida de id %s não foi encontrada!", id)));
		return medida;
	}
}
