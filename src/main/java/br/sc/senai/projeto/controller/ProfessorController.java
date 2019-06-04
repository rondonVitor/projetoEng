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

import br.sc.senai.projeto.domain.Professor;
import br.sc.senai.projeto.service.ProfessorService;
import br.sc.senai.projetoEng.components.MapValidationComponent;

@RestController
@RequestMapping("/projetoEng/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private MapValidationComponent mapValidationComponent;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Professor professor, BindingResult result) {
		
		ResponseEntity<?> errors = this.mapValidationComponent.mapValidationError(result);
		if (errors != null) {
			return errors;
		}
		
		Professor professorSalvo = this.professorService.salvar(professor);
		
		return new ResponseEntity<Professor>(professorSalvo, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Professor professor = this.professorService.buscarPorId(id);
		return new ResponseEntity<Professor>(professor, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Professor> professor = this.professorService.buscarTodos();
		return new ResponseEntity<Iterable<Professor>>(professor, HttpStatus.OK);
	}
}

