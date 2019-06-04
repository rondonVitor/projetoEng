package br.sc.senai.projeto.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "historico_de_notas")
public class HistDeNotas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name = "data_avaliacao", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataAvaliacao;
	
	@Column(name="didatica", nullable = false)
	private float didatica;
	
	@Column(name="conhecimento_da_uc", nullable = false)
	private float conhecimentoDaUc;
	
	@Column(name="criterios_de_ava", nullable = false)
	private float criteriosDeAva;
	
	@Column(name="interacao_com_aluno", nullable = false)
	private float interacaoComAluno;
	
	@Column(name="met_de_ensino", nullable = false)
	private float metDeEnsino;
	
	@Column(name="assiduidade", nullable = false)
	private float assiduidade;
	
	@Column(name="media_notas", nullable = false)
	private float mediaDasNotas;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_professor")
	private Professor professor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public float getDidatica() {
		return didatica;
	}

	public void setDidatica(float didatica) {
		this.didatica = didatica;
	}

	public float getConhecimentoDaUc() {
		return conhecimentoDaUc;
	}

	public void setConhecimentoDaUc(float conhecimentoDaUc) {
		this.conhecimentoDaUc = conhecimentoDaUc;
	}

	public float getCriteriosDeAva() {
		return criteriosDeAva;
	}

	public void setCriteriosDeAva(float criteriosDeAva) {
		this.criteriosDeAva = criteriosDeAva;
	}

	public float getInteracaoComAluno() {
		return interacaoComAluno;
	}

	public void setInteracaoComAluno(float interacaoComAluno) {
		this.interacaoComAluno = interacaoComAluno;
	}

	public float getMetDeEnsino() {
		return metDeEnsino;
	}

	public void setMetDeEnsino(float metDeEnsino) {
		this.metDeEnsino = metDeEnsino;
	}

	public float getAssiduidade() {
		return assiduidade;
	}

	public void setAssiduidade(float assiduidade) {
		this.assiduidade = assiduidade;
	}

	public float getMediaDasNotas() {
		return mediaDasNotas;
	}

	public void setMediaDasNotas(float mediaDasNotas) {
		this.mediaDasNotas = mediaDasNotas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}