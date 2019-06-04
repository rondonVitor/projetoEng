package br.sc.senai.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senai.projeto.domain.Professor;
import br.sc.senai.projeto.repositories.ProfessorRepository;
import br.senai.sc.projetoEng.exceptions.CustomRuntimeException;

@Service
public class ProfessorService {


	@Autowired
	private ProfessorRepository professorRepository;
	
	public Professor salvar(Professor professor) {
		
		Optional<Professor> professorOptional = this.professorRepository.findByCpf(professor.getCpf());
		
		if (professorOptional.isPresent()) {
			throw new CustomRuntimeException("cpf", "CPF já cadastrado!");
		}
		
		professorOptional = this.professorRepository.buscarPorEmail(professor.getEmail());
		
		if (professorOptional.isPresent()) {
			throw new CustomRuntimeException("email", "E-mail já cadastrado!");
		}
		
		return this.professorRepository.save(professor);
	}
	

	public Professor buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("id", "Não foi informado um ID para a consulta!");
		}
		
		Optional<Professor> professor = this.professorRepository.findById(id);
		if (professor.isPresent()) {
			return professor.get();
		}
		
		return null;
	}
	
	public Iterable<Professor> buscarTodos() {
		return this.professorRepository.findAll();
	}
}