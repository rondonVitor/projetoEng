package br.sc.senai.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "materias")
public class Materias {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="nome", nullable=false, length=100)
	@NotBlank(message="O nome é obrigatório")
	@Size(max=100, message="O nome deve conter no máximo 100 caracteres.")
	private String nome;
	
	@Column(name="descricao", nullable=false, columnDefinition="text")
	private String descricao;
	
	@ManyToMany
	@Column(name = "id_professor")
	private Professor professor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
