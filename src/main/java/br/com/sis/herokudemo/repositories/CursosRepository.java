package br.com.sis.herokudemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sis.herokudemo.model.Curso;

@Repository
public interface CursosRepository extends JpaRepository<Curso, Long> {

	Curso findByName(String nome);

}
