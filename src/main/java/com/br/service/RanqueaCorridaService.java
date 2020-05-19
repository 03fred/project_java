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

	public DadosCorridaDTO ranquearCorrida(List<Volta> listaVoltas) {
		List<Volta> listaMelhoresVoltasPiloto = new ArrayList<Volta>();

		Volta melhorVoltaCorrida = listaVoltas.get(0);
		Volta melhorVoltaPiloto = melhorVoltaCorrida;
		int idPiloto = melhorVoltaCorrida.getIdPiloto();
		double somaVelocidadeMedia = 0;
		Time somaTempoTotal = new Time(0);
		int contVoltas = -1;

		for (Volta volta : listaVoltas) {

			contVoltas++;
			somaVelocidadeMedia += volta.getVelocidadeMedia();

			if (Utils.retornarMelhorVolta(melhorVoltaCorrida.getTempoVolta(), volta.getTempoVolta()))
				melhorVoltaCorrida = volta;
				
			if (Utils.retornarMelhorVolta(melhorVoltaPiloto.getTempoVolta(), volta.getTempoVolta()))
				melhorVoltaPiloto = volta;
			
			somaTempoTotal = Helpers.sormarTempo(somaTempoTotal, volta.getTempoVolta());
			
			if (idPiloto != volta.getIdPiloto()) {
				double media = somaVelocidadeMedia / contVoltas;
				volta.setTempoTotalProva(somaTempoTotal);
				volta.setVoltasCompletadas(contVoltas);
				volta.setVelocidadeMediaProva(Helpers.formatarDuasCasasDecimais(media));
				volta.setTempoMelhorVolta(melhorVoltaPiloto.getTempoVolta());
				listaMelhoresVoltasPiloto.add(volta);
				idPiloto = volta.getIdPiloto();
				melhorVoltaPiloto = volta;
				contVoltas = 0;
				somaVelocidadeMedia = 0;
				somaTempoTotal = new Time(0);
				idPiloto = volta.getIdPiloto();
			}
			
		}

		Time tempoTotalVencedor = retornaTempoVencedor.retornarMelhorTempo(listaMelhoresVoltasPiloto);
		listaMelhoresVoltasPiloto = retornarVoltasDiferencaVencedor(listaMelhoresVoltasPiloto, tempoTotalVencedor);

		return new DadosCorridaDTO(listaVoltas, listaMelhoresVoltasPiloto, melhorVoltaCorrida);
	}

	private List<Volta> retornarVoltasDiferencaVencedor(List<Volta> voltas, Time tempoVencedor) {
		LocalDateTime tempoDataVencedor = this.parsearData(tempoVencedor);
		System.out.println(tempoVencedor);
		for (Volta volta : voltas) {
         
			LocalDateTime tempoDataPiloto = this.parsearData(volta.getTempoTotalProva());
			long tempototal = ChronoUnit.SECONDS.between(tempoDataVencedor, tempoDataPiloto);
			long segundos = tempototal % 60;
			long minutos = ((tempototal - segundos) / 60) % 60;
			long horas = ((tempototal - segundos - (minutos*60)))/(60*60);
			volta.setTempoPosPrimeiroColocado(horas + ":" + Helpers.formatarParaRelogio(minutos) + ":" + Helpers.formatarParaRelogio(segundos));

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
