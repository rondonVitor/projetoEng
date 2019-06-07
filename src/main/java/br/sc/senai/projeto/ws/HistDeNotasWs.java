package br.sc.senai.projeto.ws;

import javax.validation.constraints.NotNull;

public class HistDeNotasWs {
	
	private Long id;
	
	private Float didatica;
	
	private Float conhecimentoUc;
	
	private Float criteriosDeAva;
	
	private Float interacaoComAluno;
	
	private Float metDeEnsino;
	
	private Float assiduidade;
	
	private Float mediaDasNotas;
	
	@NotNull(message="É obrigatório informar o professor!")
	private Long idProfessor;

	@NotNull(message="É obrigatório informar o aluno!")
	private Long idAluno;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getDidatica() {
		return didatica;
	}

	public void setDidatica(Float didatica) {
		this.didatica = didatica;
	}

	public Float getConhecimentoUc() {
		return conhecimentoUc;
	}

	public void setConhecimentoUc(Float conhecimentoUc) {
		this.conhecimentoUc = conhecimentoUc;
	}

	public Float getCriteriosDeAva() {
		return criteriosDeAva;
	}

	public void setCriteriosDeAva(Float criteriosDeAva) {
		this.criteriosDeAva = criteriosDeAva;
	}

	public Float getInteracaoComAluno() {
		return interacaoComAluno;
	}

	public void setInteracaoComAluno(Float interacaoComAluno) {
		this.interacaoComAluno = interacaoComAluno;
	}

	public Float getMetDeEnsino() {
		return metDeEnsino;
	}

	public void setMetDeEnsino(Float metDeEnsino) {
		this.metDeEnsino = metDeEnsino;
	}

	public Float getAssiduidade() {
		return assiduidade;
	}

	public void setAssiduidade(Float assiduidade) {
		this.assiduidade = assiduidade;
	}

	public Float getMediaDasNotas() {
		return mediaDasNotas;
	}

	public void setMediaDasNotas(Float mediaDasNotas) {
		this.mediaDasNotas = mediaDasNotas;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long aluno) {
		this.idAluno = aluno;
	} 
	
	

}
