package br.com.sis.herokudemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<String> hello()
	{
		List<String> cursos = new ArrayList<>();
		cursos.add("Java 8");
		cursos.add("Angular");
		cursos.add("Spring");
		cursos.add("BootStrap");
		cursos.add("Docker");
		
		
		return cursos;
	}

}
