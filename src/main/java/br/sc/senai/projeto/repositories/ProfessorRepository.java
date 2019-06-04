package br.sc.senai.projeto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.sc.senai.projeto.domain.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

	Optional<Professor> findByCpf(String cpf);

	@Query(value="SELECT u FROM Professor u WHERE u.email LIKE %:email%")
	Optional<Professor> buscarPorEmail(@Param("email") String email);

}