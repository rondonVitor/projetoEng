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

import br.sc.senai.projeto.domain.Materias;
import br.sc.senai.projeto.service.MateriasService;
import br.sc.senai.projetoEng.components.MapValidationComponent;

@RestController
@RequestMapping("/projetoEng/materias")
public class MateriasController {
	
	@Autowired
	private MateriasService materiasService;
	
	@Autowired
	private MapValidationComponent mapValidationComponent;

	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Materias materias, BindingResult result) {
		
		ResponseEntity<?> errors = this.mapValidationComponent.mapValidationError(result);
		if (errors != null) {
			return errors;
		}
		
		Materias materiasSalvas = this.materiasService.salvar(materias);
		
		return new ResponseEntity<Materias>(materiasSalvas, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-materias-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Materias materia = this.materiasService.buscarPorId(id);
		return new ResponseEntity<Materias>(materia, HttpStatus.OK);
	}
}
