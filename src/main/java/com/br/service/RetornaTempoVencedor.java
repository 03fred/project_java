package com.br.service;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.dto.PilotoDTO;
import com.br.model.Volta;
import com.br.utils.Utils;

@Service
public class RetornaTempoVencedor {
//retorna o melhor tempo da corrida
	public Time retornarMelhorTempo(List<PilotoDTO> listaMelhorVoltaPorPiloto) {

		PilotoDTO vencedor = null;
		int numeroVoltasCorrida = 4;
		

		for (PilotoDTO dto : listaMelhorVoltaPorPiloto) {
			 
			if(dto.getVoltasCompletadas() == numeroVoltasCorrida) {
				if (vencedor == null){
					vencedor = dto;
				}
				if(Utils.retornarMelhorVolta(vencedor.getTempoTotalProva(), dto.getTempoTotalProva())) {
					vencedor = dto;
				}
			}
			
		}
         
		return vencedor.getTempoTotalProva();
	}
}
