package br.com.sis.herokudemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sis.herokudemo.model.Curso;
import br.com.sis.herokudemo.services.CursosService;

@Controller
@RequestMapping("/cursos/admin")
public class CursosAdminController {

	@Autowired
	private CursosService cursosService;

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
