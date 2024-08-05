package prova.SkyNet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova.SkyNet.entity.Filme;
import prova.SkyNet.entityDTO.FilmeDTO;
import prova.SkyNet.repository.FilmeRepository;
import prova.SkyNet.utils.FilmeMapper;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private FilmeMapper filmeMapper;
	
	public FilmeDTO getById(Long id) {
		if (id != null) {
			Filme entityFilme = getFilmeRepository().findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Filme com esse id não encontrado"));
			FilmeDTO.convertToDTO(entityFilme);
			
			
			return FilmeDTO.convertToDTO(entityFilme);

		} else {
			throw new IllegalArgumentException("Passe um id valido");
		}

	}
	
	public List<FilmeDTO> getAll() {
			List<Filme> filmes = getFilmeRepository().findAll();
			List<FilmeDTO> filmesDTO = filmes.stream().map(filme -> FilmeDTO.convertToDTO(filme)).toList();
			if(!filmesDTO.isEmpty()) {
				return filmesDTO;
			} else {
			throw new IllegalArgumentException("Passe um id valido");
		}

	}
	
	

	public String create(FilmeDTO dto) {
		if (dto != null) {
			Filme entityFilme = getFilmeMapper().covertToEntity(dto);
			getFilmeRepository().save(entityFilme);
			return "Filme Adicionado com sucesso";

		} else {
			throw new IllegalArgumentException("Passe um objeto valido");
		}

	}

	public String update( FilmeDTO dto) {
		if (dto != null && dto.getId() != null) {
			Filme entityFilme = getFilmeRepository().findById(dto.getId())
					.orElseThrow(() -> new IllegalArgumentException("Filme com esse id não encontrado"));

			entityFilme.setTitulo(dto.getTitulo() != null ? dto.getTitulo() : entityFilme.getTitulo());
			entityFilme.setGenero(dto.getGenero() != null ? dto.getGenero() : entityFilme.getGenero());
			entityFilme.setAno_Lancamento(
					dto.getAno_Lancamento() != null ? dto.getAno_Lancamento() : entityFilme.getAno_Lancamento());
			entityFilme.setDescricao(dto.getDescricao() != null ? dto.getDescricao() : entityFilme.getDescricao());
			entityFilme.setTipo(dto.getTipo() != null ? dto.getTipo() : entityFilme.getTipo());

			getFilmeRepository().save(entityFilme);
			return "Filme Alterado com sucesso";

		} else {
			throw new IllegalArgumentException("Passe um objeto valido, insira todos os dados");
		}

	}

	public String delete(Long id) {
		if (id != null) {
			Filme entityFilme = getFilmeRepository().findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Filme com esse id não encontrado"));

			getFilmeRepository().deleteById(id);
			return "Filme Excluido com sucesso com sucesso";

		} else {
			throw new IllegalArgumentException("Passe um id ");
		}

	}

	public FilmeRepository getFilmeRepository() {
		return filmeRepository;
	}

	public FilmeMapper getFilmeMapper() {
		return filmeMapper;
	}

}
