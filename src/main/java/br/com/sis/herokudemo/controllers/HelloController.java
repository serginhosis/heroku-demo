package br.com.sis.herokudemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello()
	{
		return "Hello World";
	}

}
