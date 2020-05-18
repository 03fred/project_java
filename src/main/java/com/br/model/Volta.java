package com.br.model;

import java.sql.Time;

public class Volta extends Piloto implements Comparable<Volta> {

	private String horaVolta;
	private int volta;
	private Time tempoVolta;
	private double velocidadeMedia;

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

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
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

	@Override
	public String toString() {
		return "Volta [horaVolta=" + horaVolta + ", numeroVolta=" + volta + ", tempoVolta=" + tempoVolta
				+ ", velocidadeMedia=" + velocidadeMedia + ", velocidadeMediaProva=" + getVelocidadeMediaProva()
				+ "diferecaVencedor=" + getTempoPosPrimeiroColocado() + "tempoTotalProva" + getTempoTotalProva() + "]";
	}

}
