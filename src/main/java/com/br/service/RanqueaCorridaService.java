package com.br.service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dto.DadosCorridaDTO;
import com.br.dto.PilotoDTO;
import com.br.helpers.Helpers;
import com.br.model.Volta;
import com.br.utils.Utils;

@Service
public class RanqueaCorridaService {

	@Autowired
	private RetornaTempoVencedor retornaTempoVencedor;

	public DadosCorridaDTO ranquearCorrida(List<Volta> listaVoltas) {
		List<PilotoDTO> listaMelhoresVoltasPiloto = new ArrayList<PilotoDTO>();

		Volta melhorVoltaCorrida = listaVoltas.get(0);

		for (Volta volta : listaVoltas) {

			if (Utils.retornarMelhorVolta(melhorVoltaCorrida.getTempoVolta(), volta.getTempoVolta()))
				melhorVoltaCorrida = volta;

			listaMelhoresVoltasPiloto = populaMelhorVolta(volta, listaMelhoresVoltasPiloto);
			
		}
		// busca o tempo do vencedor
		Time tempoTotalVencedor = retornaTempoVencedor.retornarMelhorTempo(listaMelhoresVoltasPiloto);

		// retorna a lista printando as difernças de tempo
		retornarVoltasDiferencaVencedor(listaMelhoresVoltasPiloto, tempoTotalVencedor);
		// ordena lista
		Collections.sort(listaMelhoresVoltasPiloto);
		// monta o retorno dto
		return new DadosCorridaDTO(listaVoltas, listaMelhoresVoltasPiloto, melhorVoltaCorrida);
	}

	private List<PilotoDTO> populaMelhorVolta(Volta volta, List<PilotoDTO> pilotos) {
		if (!ExistePiloto(volta, pilotos)) {
			pilotos.add(criarPiloto(volta));
		} else
		for (PilotoDTO piloto : pilotos) {
			if (piloto.getIdPiloto() == volta.getIdPiloto()) {
				piloto.setTempoTotalProva(Helpers.sormarTempo(piloto.getTempoTotalProva(), volta.getTempoVolta()));
				if (Utils.retornarMelhorVolta(piloto.getTempoMelhorVolta(), volta.getTempoVolta()))
					piloto.setTempoMelhorVolta(volta.getTempoVolta());

			}

		}
		return pilotos;

	}

	private boolean ExistePiloto(Volta v, List<PilotoDTO> pilotos) {
		for (PilotoDTO pilotoDTO : pilotos) {
			if (v.getIdPiloto() == pilotoDTO.getIdPiloto())
				return true;
		}
		return false;
	}

	private PilotoDTO criarPiloto(Volta volta) {
		PilotoDTO dto = new PilotoDTO();
		dto.setIdPiloto(volta.getIdPiloto());
		dto.setNomePiloto(volta.getNomePiloto());
		dto.setTempoTotalProva(volta.getTempoVolta());
		dto.setVoltasCompletadas(volta.getNumeroVolta());
		dto.setVelocidadeMediaProva(volta.getVelocidadeMedia());
		dto.setTempoMelhorVolta(volta.getTempoVolta());
		dto.setTempoPosPrimeiroColocado("");

		return dto;
	}

	// retorna a diferença com a volta do vencedor
	private List<PilotoDTO> retornarVoltasDiferencaVencedor(List<PilotoDTO> pilotos, Time tempoVencedor) {
		LocalDateTime tempoDataVencedor = this.parsearData(tempoVencedor);
		for (PilotoDTO volta : pilotos) {

			LocalDateTime tempoDataPiloto = this.parsearData(volta.getTempoTotalProva());
			long tempototal = ChronoUnit.SECONDS.between(tempoDataVencedor, tempoDataPiloto);
			long segundos = tempototal % 60;
			long minutos = ((tempototal - segundos) / 60) % 60;
			long horas = ((tempototal - segundos - (minutos * 60))) / (60 * 60);
			volta.setTempoPosPrimeiroColocado(
					horas + ":" + Helpers.formatarParaRelogio(minutos) + ":" + Helpers.formatarParaRelogio(segundos));

		}
		return pilotos;
	}

	// retorna data parseada
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
