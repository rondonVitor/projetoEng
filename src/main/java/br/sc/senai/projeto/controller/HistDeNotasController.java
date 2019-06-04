package br.sc.senai.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senai.projeto.domain.HistDeNotas;
import br.sc.senai.projeto.service.HistDeNotasService;
import br.sc.senai.projetoEng.components.MapValidationComponent;

@RestController
@RequestMapping("/projetoEng/histDeNotas")
public class HistDeNotasController {

	@Autowired
	private HistDeNotasService histDeNotasService;
	
	@Autowired
	private MapValidationComponent mapValidationComponent;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid HistDeNotas histDeNotas, BindingResult result) {
		
		ResponseEntity<?> errors = this.mapValidationComponent.mapValidationError(result);
		if (errors != null) {
			return errors;
		}
		
		HistDeNotas histDeNotasSalvas = this.histDeNotasService.salvar(histDeNotas);
		
		return new ResponseEntity<HistDeNotas>(histDeNotasSalvas, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-hist-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		HistDeNotas histNotas = this.histDeNotasService.buscarPorId(id);
		return new ResponseEntity<HistDeNotas>(histNotas, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-media-professor/{id}")
	public ResponseEntity<?> buscarMediaProfessor(@PathVariable Long id) {
		Float histNotas = this.histDeNotasService.buscarMediaProfessor(id);
		return new ResponseEntity<Float>(histNotas, HttpStatus.OK);
	}
}