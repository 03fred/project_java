package com.br.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dto.DadosCorridaDTO;
import com.br.helpers.Helpers;
import com.br.model.Volta;

@Service
public class ProcessaCorridaService {

	@Autowired
	private RanqueaCorridaService ranqueaCorridaService;

	public DadosCorridaDTO processarCorrida() throws IOException {
		ArrayList<Volta> listaVoltas = new ArrayList<Volta>();

		Path path = Paths.get("./temp/file.csv");
		Files.lines(path).skip(1L).forEach(linha -> {
			try {
				listaVoltas.add(criarVoltas(linha));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		//ordena lista
		Collections.sort(listaVoltas);

		return ranqueaCorridaService.ranquearCorrida(listaVoltas);
	}

	//cria o objeto voltas
	private Volta criarVoltas(String linha) throws ParseException {
		String dadosvolta[] = linha.split(";");
		Volta volta = new Volta();
		volta.setHoraVolta(dadosvolta[0]);
		volta.setIdPiloto(Helpers.retornarNumeros(dadosvolta[1]));
		volta.setNomePiloto(Helpers.retirarNumeros(dadosvolta[1]));
		volta.setNumeroVolta(Helpers.retornarNumeros(dadosvolta[2]));
		volta.setTempoVolta(Helpers.stringParaTempo(dadosvolta[3]));
		volta.setVelocidadeMedia(Double.parseDouble(dadosvolta[4].replaceAll(",", ".")));
		return volta;
	}

}
