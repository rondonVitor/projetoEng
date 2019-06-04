package br.sc.senai.projeto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.sc.senai.projeto.domain.HistDeNotas;

public interface HistDeNotasRepository extends CrudRepository<HistDeNotas, Long> {

	Optional<HistDeNotas> findByIdProfessor(Long professor);
}
