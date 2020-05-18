package com.br.utils;

import java.sql.Time;

public class Utils {

	public static boolean retornarMelhorVolta(Time melhorTempo, Time tempoAtual) {

		return melhorTempo.after(tempoAtual);
	}
}
