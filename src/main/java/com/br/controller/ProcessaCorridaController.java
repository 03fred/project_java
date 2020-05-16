package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.service.ProcessaCorridaService;

@Controller
@RestController
@RequestMapping(value = "/processa-corrida")
public class ProcessaCorridaController {

	@Autowired
	private ProcessaCorridaService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> processarCorridda(@RequestParam("file") MultipartFile file) {
		System.out.println("oi");
		return null;

	}
}
