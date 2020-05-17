package com.br.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.helpers.Helpers;
import com.br.model.Volta;

@Service
public class ProcessaCorridaService {

	@Autowired
	private RanqueaCorridaService ranqueaCorridaService;
	private ArrayList<Volta> listaVoltas = new ArrayList<Volta>();

	public void processarCorrida() throws IOException {
		Path path = Paths.get("./temp/file.csv");
		Files.lines(path).skip(1L).forEach(linha -> {
			listaVoltas.add(criarVoltas(linha));
		});
		Collections.sort(listaVoltas);
		ranqueaCorridaService.ranquearCorrida(listaVoltas);
	}

	private Volta criarVoltas(String linha) {
		String dadosvolta[] = linha.split(";");
		Volta volta = new Volta();
		volta.setHoraVolta(dadosvolta[0]);
		volta.setIdPiloto(Helpers.retornarNumeros(dadosvolta[1]));
		volta.setNomePiloto(Helpers.retirarNumeros(dadosvolta[1]));
		volta.setNumeroVolta(Helpers.retornarNumeros(dadosvolta[2]));
		volta.setTempoVolta(dadosvolta[3]);
		volta.setVelocidadeMedia(Double.parseDouble(dadosvolta[4].replaceAll(",", ".")));
		return volta;
	}

}
