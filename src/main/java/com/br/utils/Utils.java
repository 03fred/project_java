package com.br.utils;

import java.sql.Time;

public class Utils {

	//retorno booleano se o melhor tempo é após a data atual
	public static boolean retornarMelhorVolta(Time melhorTempo, Time tempoAtual) {

		if (melhorTempo == null) {
			return true;
		}
		return melhorTempo.after(tempoAtual);
	}
}
