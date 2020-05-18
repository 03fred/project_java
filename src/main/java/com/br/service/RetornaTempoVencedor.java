package com.br.service;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.model.Volta;
import com.br.utils.Utils;

@Service
public class RetornaTempoVencedor {

	public Time retornarMelhorTempo(List<Volta> listaMelhorVoltaPorPiloto) {

		Volta melhorTempo = listaMelhorVoltaPorPiloto.get(0);
		int numeroVoltasCorrida = 0;

		for (Volta volta : listaMelhorVoltaPorPiloto) {
             
			if (volta.getNumeroVolta() > numeroVoltasCorrida)
				numeroVoltasCorrida = volta.getNumeroVolta();

			if (Utils.retornarMelhorVolta(melhorTempo.getTempoVolta(), volta.getTempoVolta()) && volta.getNumeroVolta() == numeroVoltasCorrida)
				melhorTempo = volta;
		}
       
		return melhorTempo.getTempoTotalProva();
	}
}
