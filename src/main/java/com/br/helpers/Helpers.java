package com.br.helpers;

import java.text.DecimalFormat;

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
}
