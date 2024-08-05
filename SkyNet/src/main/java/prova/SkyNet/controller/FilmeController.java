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

import prova.SkyNet.entityDTO.FilmeDTO;
import prova.SkyNet.service.FilmeService;

@Controller
@RequestMapping(value="/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping(value="/{id}")
	private ResponseEntity<?> create(@PathVariable Long id) {
		try {
			FilmeDTO dto = getFilmeService().getById(id);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping
	private ResponseEntity<?> getAll() {
		try {
			List<FilmeDTO> listaDTO = getFilmeService().getAll();
			
			return ResponseEntity.status(HttpStatus.OK).body(listaDTO);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	
	@PostMapping
	private ResponseEntity<String> create(@RequestBody FilmeDTO dto) {
		try {
			String mensagem = getFilmeService().create(dto);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value="/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			String mensagem = getFilmeService().delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping
	private ResponseEntity<String> update(@RequestBody FilmeDTO dto) {
		try {
			String mensagem = getFilmeService().update(dto);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	

	public FilmeService getFilmeService() {
		return filmeService;
	}

}
