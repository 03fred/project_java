package com.br.utils;

import com.br.helpers.Helpers;
import com.br.model.Volta;

public class Utils {

	public static boolean retornarMelhorVolta(Volta melhorVolta, Volta voltaAtual) {

		int melhorTempo = Helpers.converterTempoVoltaParaDouble(melhorVolta.getTempoVolta());
		int tempoAtual = Helpers.converterTempoVoltaParaDouble(voltaAtual.getTempoVolta());

		if (melhorTempo > tempoAtual)
			return true;

		return false;
	}
}
