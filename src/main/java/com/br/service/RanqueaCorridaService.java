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
		int contVoltas = 0;

		for (Volta volta : listaVoltas) {
			contVoltas++;
			if (retornarMelhorVolta(melhorVoltaCorrida, volta))
				melhorVoltaCorrida = volta;

			somaVelocidadeMedia += volta.getVelocidadeMedia();

			if (idPiloto != volta.getIdPiloto()) {
				double media = somaVelocidadeMedia / contVoltas;
				somaVelocidadeMedia = 0;
				contVoltas = 0;

				melhorVoltaPiloto.setVelocidadeMediaProva(Helpers.formatarDuasCasasDecimais(media));
				listaMelhoresVoltasPiloto.add(melhorVoltaPiloto);
				idPiloto = volta.getIdPiloto();
				melhorVoltaPiloto = volta;
			}

			if (retornarMelhorVolta(melhorVoltaPiloto, volta))
				melhorVoltaPiloto = volta;
		}

	}

	private boolean retornarMelhorVolta(Volta melhorVolta, Volta voltaAtual) {

		int melhorTempo = Integer.parseInt(melhorVolta.getTempoVolta().replace(":", "").replace(".", "").trim());
		int tempoAtual = Integer.parseInt(voltaAtual.getTempoVolta().replace(":", "").replace(".", "").trim());

		if (melhorTempo > tempoAtual)
			return true;

		return false;
	}
}
