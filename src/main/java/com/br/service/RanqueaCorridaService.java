package com.br.service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dto.DadosCorridaDTO;
import com.br.helpers.Helpers;
import com.br.model.Volta;
import com.br.utils.Utils;

@Service
public class RanqueaCorridaService {

	@Autowired
	private RetornaTempoVencedor retornaTempoVencedor;

	private List<Volta> listaMelhoresVoltasPiloto = new ArrayList<Volta>();

	public DadosCorridaDTO ranquearCorrida(List<Volta> listaVoltas) {
		Volta melhorVoltaCorrida = listaVoltas.get(0);
		Volta melhorVoltaPiloto = melhorVoltaCorrida;
		int idPiloto = melhorVoltaCorrida.getIdPiloto();
		double somaVelocidadeMedia = 0;
		Time somaTempoTotal = new Time(0);
		int contVoltas = 0;

		for (Volta volta : listaVoltas) {

			contVoltas++;

			if (Utils.retornarMelhorVolta(melhorVoltaCorrida.getTempoVolta(), volta.getTempoVolta()))
				melhorVoltaCorrida = volta;

			somaVelocidadeMedia += volta.getVelocidadeMedia();
			somaTempoTotal = Helpers.sormarTempo(somaTempoTotal, volta.getTempoVolta());

			if (idPiloto != volta.getIdPiloto()) {
				double media = somaVelocidadeMedia / contVoltas;
         		volta.setTempoTotalProva(somaTempoTotal);
				listaMelhoresVoltasPiloto.add(volta);
				idPiloto = volta.getIdPiloto();
				melhorVoltaPiloto = volta;
				contVoltas = 0;
				somaVelocidadeMedia = 0;
				somaTempoTotal = new Time(0);
			}

			if (Utils.retornarMelhorVolta(melhorVoltaPiloto.getTempoVolta(), volta.getTempoVolta()))
				melhorVoltaPiloto = volta;
		}

		Time tempoTotalVencedor = retornaTempoVencedor.retornarMelhorTempo(listaMelhoresVoltasPiloto);
		listaMelhoresVoltasPiloto = retornarVoltasDiferencaVencedor(listaMelhoresVoltasPiloto, tempoTotalVencedor);

		return new DadosCorridaDTO(listaVoltas, listaMelhoresVoltasPiloto, melhorVoltaCorrida);
	}

	private List<Volta> retornarVoltasDiferencaVencedor(List<Volta> voltas, Time tempoVencedor) {
		LocalDateTime tempoDataVencedor = this.parsearData(tempoVencedor);
		for (Volta volta : voltas) {

			LocalDateTime tempoDataPiloto = this.parsearData(volta.getTempoTotalProva());
			long minutos = ChronoUnit.MINUTES.between(tempoDataVencedor, tempoDataPiloto);
			long segundos = ChronoUnit.SECONDS.between(tempoDataVencedor, tempoDataPiloto);
			long horas = ChronoUnit.HOURS.between(tempoDataVencedor, tempoDataPiloto);
			volta.setTempoPosPrimeiroColocado(horas + ":" + minutos + ":" + segundos);
            System.out.println(minutos);
            System.out.println(segundos);
		}
		return voltas;
	}


	private LocalDateTime parsearData(Time tempo) {
		Date dataAtual = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dataFormatada = dateFormat.format(dataAtual);

		String str = dataFormatada + " " + String.valueOf(tempo);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, format);

		return dateTime;
	}

}
