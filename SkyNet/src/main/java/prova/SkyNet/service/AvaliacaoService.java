package prova.SkyNet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova.SkyNet.entity.Avaliacao;
import prova.SkyNet.entity.Filme;
import prova.SkyNet.entityDTO.AvaliacaoDTO;
import prova.SkyNet.repository.AvaliacaoRepository;
import prova.SkyNet.repository.FilmeRepository;
import prova.SkyNet.utils.AvaliacaoMapper;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private AvaliacaoMapper avaliacaoMapper;
	
	public List<AvaliacaoDTO> getAll() {
		List<Avaliacao> avaliacoes = getAvaliacaoRepository().findAll();
		List<AvaliacaoDTO> valiacoesDTO = avaliacoes.stream().map(avaliacao -> AvaliacaoDTO.convertToDTO(avaliacao)).toList();
		if(!valiacoesDTO.isEmpty()) {
			return valiacoesDTO;
		} else {
		throw new IllegalArgumentException("Lista Vazia");
	}

}

	

	public String create(AvaliacaoDTO dto) {
		if (dto != null) {
			Avaliacao entityAvaliacao = getAvaliacaoMapper().covertToEntity(dto);
			Filme filme = getFilmeRepository().findById(dto.getId_Filme())
					.orElseThrow(() -> new IllegalArgumentException("Filme com esse id não encontrado"));
			entityAvaliacao.setFilme(filme);
			getAvaliacaoRepository().save(entityAvaliacao);
			
			return "Avaliacao Adicionado com sucesso";

		} else {
			throw new IllegalArgumentException("Passe um objeto valido");
		}

	}
	
	public String delete(Long id) {
		if (id != null) {
			Avaliacao entityAvaliacao = getAvaliacaoRepository().findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Avaliacao com esse id não encontrado"));

			getAvaliacaoRepository().deleteById(id);
			return "Avaliacao Excluida com sucesso com sucesso";

		} else {
			throw new IllegalArgumentException("Passe um id ");
		}

	}
	
	
	public String update(AvaliacaoDTO dto) {
		if (dto != null && dto.getId() != null) {
		Avaliacao entityAvaliacao = getAvaliacaoRepository().findById(dto.getId())
					.orElseThrow(() -> new IllegalArgumentException("Avaliacao com esse id não encontrado"));

		Filme filme = getFilmeRepository().findById(dto.getId_Filme())
				.orElseThrow(() -> new IllegalArgumentException("Filme com esse id não encontrado"));
		
		entityAvaliacao.setFilme(dto.getId_Filme() != null ? filme : entityAvaliacao.getFilme());
		entityAvaliacao.setNomeUsuario(dto.getNomeUsuario() != null ? dto.getNomeUsuario() : entityAvaliacao.getNomeUsuario());
		entityAvaliacao.setNota(dto.getNota() != null ? dto.getNota() : entityAvaliacao.getNota());
		entityAvaliacao.setComentario(dto.getComentario() != null ? dto.getComentario() : entityAvaliacao.getComentario());
		entityAvaliacao.setDataAvaliacao(dto.getDataAvaliacao() != null ? dto.getDataAvaliacao() : entityAvaliacao.getDataAvaliacao());		
		getAvaliacaoRepository().save(entityAvaliacao);

		return "Avaliacao alterada com sucesso";
		} else {
			throw new IllegalArgumentException("Passe um objeto valido, insira todos os dados");
		}

	}

	public AvaliacaoRepository getAvaliacaoRepository() {
		return avaliacaoRepository;
	}

	public AvaliacaoMapper getAvaliacaoMapper() {
		return avaliacaoMapper;
	}

	public FilmeRepository getFilmeRepository() {
		return filmeRepository;
	}

}
