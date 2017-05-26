package br.com.sis.herokudemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class HerokuDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerokuDemoApplication.class, args);
	}
}
