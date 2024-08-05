package prova.SkyNet.utils;

import org.springframework.stereotype.Component;

import prova.SkyNet.entity.Avaliacao;
import prova.SkyNet.entityDTO.AvaliacaoDTO;

@Component
 public class AvaliacaoMapper {
	
	public Avaliacao covertToEntity(AvaliacaoDTO dto) {
		Avaliacao entity = new Avaliacao();
		entity.setId(dto.getId());
		entity.setNomeUsuario(dto.getNomeUsuario());
		entity.setNota(dto.getNota());
		entity.setComentario(dto.getComentario());
		entity.setDataAvaliacao(dto.getDataAvaliacao());
		
		return entity;
	}

}
