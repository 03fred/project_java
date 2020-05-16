package com.br.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
	public ResponseEntity<Void> processarCorridda(@RequestParam("file") MultipartFile file) throws IOException {

		if (file != null) {
			File copied = new File("./temp/file.csv");
			InputStream input = file.getInputStream();
			OutputStream out = new BufferedOutputStream(new FileOutputStream(copied));

			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = input.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}

		service.processarCorrida();
		return null;
	}
}
