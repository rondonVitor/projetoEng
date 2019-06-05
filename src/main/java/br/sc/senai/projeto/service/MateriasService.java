package br.sc.senai.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senai.projeto.domain.Materias;
import br.sc.senai.projeto.repositories.MateriasRepository;
import br.senai.sc.projetoEng.exceptions.CustomRuntimeException;

@Service
public class MateriasService {

	@Autowired
	private MateriasRepository materiasRepository;
	
	public Materias salvar(Materias materias) {
		if (materias == null) {
			throw new CustomRuntimeException("materias", "Materia não foi encontrada!");
		}
		
		return this.materiasRepository.save(materias);
	}
	
	public Materias buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("id", "Não foi informado um ID para a consulta!");
		}
		
		Optional<Materias> materia = this.materiasRepository.findById(id);
		if (materia.isPresent()) {
			return materia.get();
		}
		
		return null;
	}
	
}
