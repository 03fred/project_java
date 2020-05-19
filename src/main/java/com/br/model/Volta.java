package com.br.model;

import java.sql.Time;

public class Volta extends Piloto implements Comparable<Volta> {

	private String horaVolta;
	private int volta;
	private Time tempoVolta;

	public String getHoraVolta() {
		return horaVolta;
	}

	public void setHoraVolta(String horaVolta) {
		this.horaVolta = horaVolta;
	}

	public int getNumeroVolta() {
		return volta;
	}

	public void setNumeroVolta(int numeroVolta) {
		this.volta = numeroVolta;
	}

	public Time getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(Time tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	@Override
	public int compareTo(Volta novaVolta) {
		if (this.getIdPiloto() > novaVolta.getIdPiloto()) {
			return -1;
		}
		if (this.getIdPiloto() < novaVolta.getIdPiloto()) {
			return 1;
		}
		return 0;
	}

}
