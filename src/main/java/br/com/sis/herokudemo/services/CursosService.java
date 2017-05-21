package br.com.sis.herokudemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.herokudemo.model.Curso;
import br.com.sis.herokudemo.repositories.CursosRepository;

@Service
public class CursosService {

	@Autowired
	private CursosRepository cursosRepository;

	public List<Curso> listAll() {
		return cursosRepository.findAll();
	}

	public void salvar(Curso curso) {
		cursosRepository.save(curso);
	}

}
