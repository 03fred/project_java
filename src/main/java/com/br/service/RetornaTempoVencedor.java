package com.br.service;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.model.Volta;
import com.br.utils.Utils;

@Service
public class RetornaTempoVencedor {

	public Time retornarMelhorTempo(List<Volta> listaMelhorVoltaPorPiloto) {

		Volta melhorTempo = null;
		int numeroVoltasCorrida = 4;
		

		for (Volta volta : listaMelhorVoltaPorPiloto) {

			if(volta.getVoltasCompletadas() == numeroVoltasCorrida) {
				if (melhorTempo == null){
					melhorTempo = volta;
				}
				if(Utils.retornarMelhorVolta(melhorTempo.getTempoTotalProva(), volta.getTempoTotalProva())) {
					melhorTempo = volta;
				}
			}
			
		}

		return melhorTempo.getTempoTotalProva();
	}
}
