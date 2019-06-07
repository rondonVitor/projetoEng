package br.sc.senai.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senai.projeto.domain.Aluno;
import br.sc.senai.projeto.domain.HistDeNotas;
import br.sc.senai.projeto.domain.Professor;
import br.sc.senai.projeto.repositories.HistDeNotasRepository;
import br.sc.senai.projeto.ws.HistDeNotasWs;
import br.senai.sc.projetoEng.exceptions.CustomRuntimeException;


@Service
public class HistDeNotasService {

	@Autowired
	private HistDeNotasRepository histDeNotasRepository;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private AlunoService alunoService;
	
	public HistDeNotas salvar(HistDeNotasWs histDeNotasws) {
		HistDeNotas histDeNotas = this.parseHistNotasWsToHistNotas(histDeNotasws);
		float soma = 0.0f;
		
		soma += histDeNotas.getAssiduidade();
		soma += histDeNotas.getConhecimentoDaUc();
		soma += histDeNotas.getCriteriosDeAva();
		soma += histDeNotas.getDidatica();
		soma += histDeNotas.getInteracaoComAluno();
		soma += histDeNotas.getMetDeEnsino();
		
		histDeNotas.setMediaDasNotas(soma / 6);
		
		return this.histDeNotasRepository.save(histDeNotas);
	}
	
	private HistDeNotas parseHistNotasWsToHistNotas(HistDeNotasWs histDeNotasWs) {
		Professor professor = this.obterProfessor(histDeNotasWs.getIdProfessor());
		Aluno aluno = this.obterAluno(histDeNotasWs.getIdAluno());
		HistDeNotas histDeNotas = new HistDeNotas();
		histDeNotas.setAssiduidade(histDeNotasWs.getAssiduidade());
		histDeNotas.setConhecimentoDaUc(histDeNotasWs.getConhecimentoUc());
		histDeNotas.setCriteriosDeAva(histDeNotasWs.getCriteriosDeAva());
		histDeNotas.setDidatica(histDeNotasWs.getDidatica());
		histDeNotas.setMetDeEnsino(histDeNotasWs.getMetDeEnsino());
		histDeNotas.setMediaDasNotas(histDeNotasWs.getMediaDasNotas());
		histDeNotas.setProfessor(professor);
		
		return histDeNotas;
	}
	
	public HistDeNotas buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("id", "Não foi informado um ID para a consulta!");
		}
		
		Optional<HistDeNotas> histNotas = this.histDeNotasRepository.findById(id);
		if (histNotas.isPresent()) {
			return histNotas.get();
		}
		
		return null;
	}
	
	public Aluno obterAluno(Long idAluno) {
		Aluno aluno = this.alunoService.buscarPorId(idAluno);
		if (aluno == null) {
			throw new CustomRuntimeException("aluno", "Aluno não encontrador!");
		}
		return aluno;
	}
	
	public Professor obterProfessor(Long idProfessor) {
		Professor professor = this.professorService.buscarPorId(idProfessor);
		if (professor == null) {
			throw new CustomRuntimeException("professor", "Professor não encontrador!");
		}
		return professor;
	}
	
	public Float buscarMediaProfessor(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("id", "Não foi informado um ID para a consulta!");
		}
		
		Optional<HistDeNotas> professor = this.histDeNotasRepository.findByIdProfessor(id);
		
		return professor.get().getMediaDasNotas();
	}
	
}