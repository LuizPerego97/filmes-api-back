package prova.SkyNet.utils;

import org.springframework.stereotype.Component;

import prova.SkyNet.entity.Filme;
import prova.SkyNet.entityDTO.FilmeDTO;

@Component
public class FilmeMapper {

	
	public Filme covertToEntity(FilmeDTO dto) {
		Filme entity = new Filme();
		entity.setId(dto.getId());
		entity.setTitulo(dto.getTitulo());
		entity.setGenero(dto.getGenero());
		entity.setAno_Lancamento(dto.getAno_Lancamento());
		entity.setDescricao(dto.getDescricao());
		entity.setTipo(dto.getGenero());
		
		return entity;
	}
}
