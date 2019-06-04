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

import br.sc.senai.projeto.domain.Aluno;
import br.sc.senai.projeto.service.AlunoService;
import br.sc.senai.projetoEng.components.MapValidationComponent;

@RestController
@RequestMapping("/projetoEng/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private MapValidationComponent mapValidationComponent;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Aluno aluno, BindingResult result) {
		
		ResponseEntity<?> errors = this.mapValidationComponent.mapValidationError(result);
		if (errors != null) {
			return errors;
		}
		
		Aluno alunoSalvo = this.alunoService.salvar(aluno);
		
		return new ResponseEntity<Aluno>(alunoSalvo, HttpStatus.OK);
	}

	@GetMapping("/buscar-aluno/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Aluno aluno = this.alunoService.buscarPorId(id);
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Aluno> aluno = this.alunoService.buscarTodos();
		return new ResponseEntity<Iterable<Aluno>>(aluno, HttpStatus.OK);
	}

}

