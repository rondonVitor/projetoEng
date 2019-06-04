package br.sc.senai.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "professores")
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nome", nullable=false, length=100)
	@NotBlank(message="O nome é obrigatório")
	@Size(max=100, message="O nome deve conter no máximo 100 caracteres.")
	private String nome;
	
	@Column(name="telefone", nullable=false, length=14)
	@NotBlank(message="O telefone é obrigatório")
	@Size(max=100, message="O telefone deve conter no máximo 14 números.")
	private String telefone;

	@Column(name = "cpf", nullable = false, length = 14, unique = true)
	@NotBlank(message="O CPF é obrigatório.")
	@Size(message="O CPF deve estar no padrão XXX.XXX.XXX-XX", max=14, min=14)
	private String cpf;
	
	@Column(name = "email", nullable = false, length=100, unique = true)
	@NotBlank(message="O e-mail é obrigatório.")
	@Size(max=100, message="O e-mail deve conter no máximo 100 caracteres.")
	@Email(message="O formato de e-mail é inválido.")
	private String email;
	
	@Column(name="conta_ativa", nullable=false, length=100)
	@NotBlank(message="A flag de conta ativa deve ser inserida.")
	@Size(max=1, message="A flag de conta ativa deve conter apenas um número (0 ou 1).")
	private byte contaAtiva;
	
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(byte contaAtiva) {
		this.contaAtiva = contaAtiva;
	}
	
}
