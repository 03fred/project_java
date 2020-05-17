package com.br.model;

public class Volta extends Piloto implements Comparable<Volta> {

	private String horaVolta;
	private int numeroVolta;
	private String tempoVolta;
	private double velocidadeMedia;

	public String getHoraVolta() {
		return horaVolta;
	}

	public void setHoraVolta(String horaVolta) {
		this.horaVolta = horaVolta;
	}

	public int getNumeroVolta() {
		return numeroVolta;
	}

	public void setNumeroVolta(int numeroVolta) {
		this.numeroVolta = numeroVolta;
	}

	public String getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(String tempoVolta) {
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
		return "Volta [horaVolta=" + horaVolta + ", numeroVolta=" + numeroVolta + ", tempoVolta=" + tempoVolta
				+ ", velocidadeMedia=" + velocidadeMedia + ", velocidadeMediaProva="+ getVelocidadeMediaProva() +
				"diferecaVencedor="+ getTempoPosPrimeiroColocado() + "tempoTotalProva" + getTempoTotalProva()+
				"]";
	}

}
