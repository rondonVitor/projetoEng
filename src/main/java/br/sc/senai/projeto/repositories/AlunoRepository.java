package br.sc.senai.projeto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.sc.senai.projeto.domain.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

	Optional<Aluno> findByCpf(String cpf);

	@Query(value="SELECT u FROM Aluno u WHERE u.email LIKE %:email%")
	Optional<Aluno> buscarPorEmail(@Param("email") String email);

}