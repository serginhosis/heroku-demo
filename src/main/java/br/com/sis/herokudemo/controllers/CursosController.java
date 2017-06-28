package br.com.sis.herokudemo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.sis.herokudemo.model.Curso;
import br.com.sis.herokudemo.services.CursosService;

@RestController
public class CursosController {

	@Autowired
	private CursosService cursosService;

	@GetMapping("/cursos")
	public List<Curso> hello() {
		return cursosService.listAll();
	}

	@GetMapping("/cursos/{nome}")
	public Curso findByNome(@PathVariable("nome") String nome) {
		return cursosService.findByNome(nome);
	}

	@PostMapping(value = "/cursos/adicionar", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionaJson(@RequestBody Curso curso, HttpServletResponse response, HttpServletRequest request) {

		cursosService.salvar(curso);

		response.addHeader("Location",
				request.getLocalAddr() + ":" + request.getServerPort() + "/cursos/" + curso.getNome());

	}

	@DeleteMapping("/cursos/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") long id) {
		System.out.println("Apagando o registro " + id);
		cursosService.deletar(id);
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
