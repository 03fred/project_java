package com.br.helpers;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers {

	public static int retornarNumeros(String str) {
		return Integer.parseInt(str.replaceAll("[^0-9]", ""));
	}

	public static String retirarNumeros(String str) {
		return str.replaceAll("[0-9]", "");
	}

	public static String formatarDuasCasasDecimais(double valor) {
		DecimalFormat df = new DecimalFormat("###.00");
		return df.format(valor);
	}

	public static double converterTempoVoltaParaDouble(String tempo) {
		return Double.parseDouble(tempo.replace(":", "").trim());
	}

	public static Time sormarTempo(Time tempoAtual, Time somaTempo) {
		Long t1time = tempoAtual.getTime();
		if (tempoAtual.getTime() > 0)
			t1time -= 3 * 60 * 60 * 1000;
		return new Time(t1time + somaTempo.getTime());
	}


	public static  Time stringParaTempo(String tempo) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("mm:ss.SSS"); 

		java.util.Date d1 = (Date) format.parse(tempo);

		return new Time(d1.getTime());
	}
}
