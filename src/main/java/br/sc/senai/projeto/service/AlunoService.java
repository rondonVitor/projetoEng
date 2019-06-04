package br.sc.senai.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senai.projeto.domain.Aluno;
import br.sc.senai.projeto.repositories.AlunoRepository;
import br.senai.sc.projetoEng.exceptions.CustomRuntimeException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno salvar(Aluno aluno) {

		Optional<Aluno> alunoOptional = this.alunoRepository.findByCpf(aluno.getCpf());

		if (alunoOptional.isPresent()) {
			throw new CustomRuntimeException("cpf", "CPF já cadastrado!");
		}

		alunoOptional = this.alunoRepository.buscarPorEmail(aluno.getEmail());

		if (alunoOptional.isPresent()) {
			throw new CustomRuntimeException("email", "E-mail já cadastrado!");
		}

		return this.alunoRepository.save(aluno);
	}

	public Aluno buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("id", "Não foi informado um ID para a consulta!");
		}

		Optional<Aluno> aluno = this.alunoRepository.findById(id);
		if (aluno.isPresent()) {
			return aluno.get();
		}

		return null;
	}

	public Iterable<Aluno> buscarTodos() {
		return this.alunoRepository.findAll();
	}
}