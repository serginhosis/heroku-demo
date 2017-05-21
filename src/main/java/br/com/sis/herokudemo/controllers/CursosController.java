package br.com.sis.herokudemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.sis.herokudemo.model.Curso;
import br.com.sis.herokudemo.services.CursosService;

@RequestMapping("/cursos")
@RestController
public class CursosController {

	@Autowired
	private CursosService cursosService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Curso> hello() {

		return cursosService.listAll();
	}

	@RequestMapping(value = "/add/{nome}", method = RequestMethod.GET)
	public String add(@PathVariable String nome) {
		Curso curso = new Curso(nome);
		cursosService.salvar(curso);
		return "Curso " + nome + " foi adicionado";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView form(Curso curso) {
		ModelAndView mav = new ModelAndView("cursos");
		mav.addObject("cursos", cursosService.listAll());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView list(Curso curso) {

		cursosService.salvar(curso);

		curso = new Curso();
		ModelAndView mav = new ModelAndView("cursos");
		mav.addObject("cursos", cursosService.listAll());
		return mav;

	}

}
