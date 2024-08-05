package prova.SkyNet.entityDTO;

import java.sql.Date;

import org.modelmapper.ModelMapper;

import prova.SkyNet.entity.Avaliacao;

public class AvaliacaoDTO {
	
	private Long id;
	
	private FilmeDTO filmeDTO;
	
	private Long id_Filme;
	
	private String nomeUsuario;
	
	private Long nota;
	
	private	String comentario;
	
	private	Date dataAvaliacao;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FilmeDTO getFilmeDTO() {
		return filmeDTO;
	}

	public void setFilmeDTO(FilmeDTO filmeDTO) {
		this.filmeDTO = filmeDTO;
	}

	public Long getId_Filme() {
		return id_Filme;
	}

	public void setId_Filme(Long id_Filme) {
		this.id_Filme = id_Filme;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	public static AvaliacaoDTO convertToDTO(Avaliacao entity) {
		return getModelMapper().map(entity, AvaliacaoDTO.class);
	}

}
