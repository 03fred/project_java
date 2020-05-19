package com.br.dto;

import java.sql.Time;

import com.br.utils.Utils;

public class PilotoDTO implements Comparable<PilotoDTO> {

	private int idPiloto;
	private String nomePiloto;
	private double velocidadeMediaProva;
	private Time tempoMelhorVolta;
	private Time tempoTotalProva;
	private String tempoPosPrimeiroColocado;
	private int voltasCompletadas;

	public int getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public double getVelocidadeMediaProva() {
		return velocidadeMediaProva;
	}

	public void setVelocidadeMediaProva(double velocidadeMediaProva) {
		this.velocidadeMediaProva = velocidadeMediaProva;
	}

	public Time getTempoMelhorVolta() {
		return tempoMelhorVolta;
	}

	public void setTempoMelhorVolta(Time tempoMelhorVolta) {
		this.tempoMelhorVolta = tempoMelhorVolta;
	}

	public Time getTempoTotalProva() {
		return tempoTotalProva;
	}

	public void setTempoTotalProva(Time tempoTotalProva) {
		this.setVoltasCompletadas(this.getVoltasCompletadas()+1);
		this.tempoTotalProva = tempoTotalProva;
	}

	public String getTempoPosPrimeiroColocado() {
		return tempoPosPrimeiroColocado;
	}

	public void setTempoPosPrimeiroColocado(String tempoPosPrimeiroColocado) {
		this.tempoPosPrimeiroColocado = tempoPosPrimeiroColocado;
	}

	public int getVoltasCompletadas() {
		return voltasCompletadas;
	}

	public void setVoltasCompletadas(int voltasCompletadas) {
		this.voltasCompletadas = voltasCompletadas;
	}

	@Override
	public int compareTo(PilotoDTO piloto) {
		if (!Utils.retornarMelhorVolta(this.tempoTotalProva, piloto.getTempoTotalProva())) {
			return -1;
		}
		if (Utils.retornarMelhorVolta(this.tempoTotalProva, piloto.getTempoTotalProva())) {
			return 1;
		}
		return 0;
	}
}
