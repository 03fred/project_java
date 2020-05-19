package com.br.model;

import java.sql.Time;

public class Piloto {

	private int id;
	private String nome;
	private double velocidadeMedia;
	private String velocidadeMediaProva;
	private Time tempoMelhorVolta;
	private Time tempoTotalProva;
	private String tempoPosPrimeiroColocado;
	private int voltasCompletadas;

	public int getIdPiloto() {
		return id;
	}

	public void setIdPiloto(int idPiloto) {
		this.id = idPiloto;
	}

	public String getNomePiloto() {
		return nome;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nome = nomePiloto;
	}


	public Time getTempoTotalProva() {
		return tempoTotalProva;
	}

	public void setTempoTotalProva(Time tempoTotalProva) {
		this.tempoTotalProva = tempoTotalProva;
	}

	public Time getTempoMelhorVolta() {
		return tempoMelhorVolta;
	}

	public void setTempoMelhorVolta(Time tempoMelhorVolta) {
		this.tempoMelhorVolta = tempoMelhorVolta;
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

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	public String getVelocidadeMediaProva() {
		return velocidadeMediaProva;
	}

	public void setVelocidadeMediaProva(String velocidadeMediaProva) {
		this.velocidadeMediaProva = velocidadeMediaProva;
	}

}
