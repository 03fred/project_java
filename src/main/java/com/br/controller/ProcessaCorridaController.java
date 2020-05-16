package com.br.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.service.ProcessaCorridaService;

@Controller
@RestController
@RequestMapping(value = "/processar-corrida")
public class ProcessaCorridaController {

	@Autowired
	private ProcessaCorridaService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> processarCorridda(File file) {
		service.processarCorrida(file);
		return null;

	}
}
