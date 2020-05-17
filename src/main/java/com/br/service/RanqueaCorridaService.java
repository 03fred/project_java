package com.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.helpers.Helpers;
import com.br.model.Volta;

@Service
public class RanqueaCorridaService {

	private List<Volta> listaMelhoresVoltasPiloto = new ArrayList<Volta>();

	public void ranquearCorrida(List<Volta> listaVoltas) {
		Volta melhorVoltaCorrida = listaVoltas.get(0);
		Volta melhorVoltaPiloto = melhorVoltaCorrida;
		int idPiloto = melhorVoltaCorrida.getIdPiloto();
		double somaVelocidadeMedia = 0;
		double somaTempoTotal = 0;
		int contVoltas = 0;

		for (Volta volta : listaVoltas) {

			contVoltas++;

			if (retornarMelhorVolta(melhorVoltaCorrida, volta))
				melhorVoltaCorrida = volta;

			somaVelocidadeMedia += volta.getVelocidadeMedia();
			somaTempoTotal += Helpers.converterTempoVoltaParaDouble(volta.getTempoVolta());

			if (idPiloto != volta.getIdPiloto()) {
				double media = somaVelocidadeMedia / contVoltas;

				melhorVoltaPiloto.setVelocidadeMediaProva(Helpers.formatarDuasCasasDecimais(media));
				melhorVoltaPiloto.setTempoTotalProva(somaTempoTotal);

				listaMelhoresVoltasPiloto.add(melhorVoltaPiloto);

				idPiloto = volta.getIdPiloto();
				melhorVoltaPiloto = volta;
				contVoltas = 0;
				somaVelocidadeMedia = 0;
				somaTempoTotal = 0;
			}

			if (retornarMelhorVolta(melhorVoltaPiloto, volta))
				melhorVoltaPiloto = volta;
		}

	}

	private boolean retornarMelhorVolta(Volta melhorVolta, Volta voltaAtual) {

		int melhorTempo = Helpers.converterTempoVoltaParaDouble(melhorVolta.getTempoVolta());
		int tempoAtual = Helpers.converterTempoVoltaParaDouble(voltaAtual.getTempoVolta());

		if (melhorTempo > tempoAtual)
			return true;

		return false;
	}
}
