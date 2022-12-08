package br.edu.infnet.catalogo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.domain.entities.Medida;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeEmUsoException;
import br.edu.infnet.catalogo.domain.exceptions.EntidadeNaoEncontradaException;
import br.edu.infnet.catalogo.domain.exceptions.RegraDeNegocioException;
import br.edu.infnet.catalogo.domain.repositories.MedidaRepository;
import br.edu.infnet.catalogo.domain.utils.CatalogoUtils;

@Service
public class MedidaServiceImpl implements MedidaService {

	@Autowired
	MedidaRepository medidaRepository;

	public List<Medida> obterTodos() {
		return medidaRepository.findAll();
	}

	public Medida obterPorId(Long id) {
		Optional<Medida> medida = medidaRepository.findById(id);
		if (medida.isEmpty())
			throw new EntidadeNaoEncontradaException(String.format("A medida de id %s não foi encontrada!", id));
		return medida.get();
	}

	public Medida salvar(Medida medida) {
		formatMedida(medida);
		if (medidaRepository.findByNome(medida.getNome()).isPresent())
			throw new RegraDeNegocioException(
					String.format("Operação não permitida, já existe uma medida com o nome %s!", medida.getNome()));
		if (medidaRepository.findBySigla(medida.getSigla()).isPresent())
			throw new RegraDeNegocioException(
					String.format("Operação não permitida, já existe uma medida com a sigla %s!", medida.getSigla()));
		return medidaRepository.save(medida);
	}

	public Medida atualizar(Long id, Medida medida) {
		formatMedida(medida);
		Medida medidaPorId = obterPorId(id);
		BeanUtils.copyProperties(medida, medidaPorId, "id");
		return medidaRepository.save(medidaPorId);
	}

	public void excluir(Long id) {
		Medida medida = obterPorId(id);
		try {
			medidaRepository.delete(medida);
		} catch (Exception e) {
			throw new EntidadeEmUsoException(String.format("A medida de id %s não pode ser excluída!", id));
		}
	}

	private void formatMedida(Medida medida) {
		medida.setNome(CatalogoUtils.capitalize(medida.getNome()));
		medida.setSigla(CatalogoUtils.makeUpperCase(medida.getSigla()));
	}
}
