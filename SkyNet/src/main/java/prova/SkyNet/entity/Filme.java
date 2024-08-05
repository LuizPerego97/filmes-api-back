package prova.SkyNet.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="FILMES_SERIES")
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TITULO", nullable = true, unique = true)
	private String titulo;
	
	@Column(name="GENERO",nullable = true)
	private String genero;
	
	@Column(name="ANO_LANCAMENTO",nullable = true)
	private Long ano_Lancamento;
	
	@Column(name="DESCRICAO",nullable = true, unique = true)
	private String descricao;
	
	@Column(name="TIPO",nullable = true)
	private String tipo;
	
	@OneToMany(mappedBy = "filme")
	List<Avaliacao> avaliacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getAno_Lancamento() {
		return ano_Lancamento;
	}

	public void setAno_Lancamento(Long ano_Lancamento) {
		this.ano_Lancamento = ano_Lancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	

}
