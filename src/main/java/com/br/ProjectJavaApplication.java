package com.br;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.br.service.ProcessaCorridaService;

@SpringBootApplication
public class ProjectJavaApplication  extends SpringBootServletInitializer implements CommandLineRunner  {

	@Autowired
	private ProcessaCorridaService processaCorridaService;
	public static void main(String[] args) {
		SpringApplication.run(ProjectJavaApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		processaCorridaService.processarCorrida();
	}

}
