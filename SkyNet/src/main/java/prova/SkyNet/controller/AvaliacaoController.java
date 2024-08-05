package prova.SkyNet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import prova.SkyNet.entityDTO.AvaliacaoDTO;
import prova.SkyNet.service.AvaliacaoService;

@Controller
@RequestMapping(value="/avaliacoes")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping
	private ResponseEntity<?> getAll() {
		try {
			List<AvaliacaoDTO> listaDTO = getAvaliacaoService().getAll();
			
			return ResponseEntity.status(HttpStatus.OK).body(listaDTO);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	
	@PostMapping
	private ResponseEntity<String> create(@RequestBody AvaliacaoDTO dto ) {
		try {
			String mensagem = getAvaliacaoService().create(dto);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value="/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			String mensagem = getAvaliacaoService().delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping
	private ResponseEntity<String> update(@RequestBody AvaliacaoDTO dto) {
		try {
			String mensagem = getAvaliacaoService().update(dto);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	


	public AvaliacaoService getAvaliacaoService() {
		return avaliacaoService;
	}

}
