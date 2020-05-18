package com.br.model;

import java.sql.Time;

public class Piloto {

	private int idPiloto;
	private String nomePiloto;
	private String velocidadeMediaProva;
	private Time tempoTotalProva;
	private String tempoPosPrimeiroColocado;

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

	public String getVelocidadeMediaProva() {
		return velocidadeMediaProva;
	}

	public void setVelocidadeMediaProva(String velocidadeMediaProva) {
		this.velocidadeMediaProva = velocidadeMediaProva;
	}

	public Time getTempoTotalProva() {
		return tempoTotalProva;
	}

	public void setTempoTotalProva(Time tempoTotalProva) {
		this.tempoTotalProva = tempoTotalProva;
	}

	public String getTempoPosPrimeiroColocado() {
		return tempoPosPrimeiroColocado;
	}

	public void setTempoPosPrimeiroColocado(String tempoPosPrimeiroColocado) {
		this.tempoPosPrimeiroColocado = tempoPosPrimeiroColocado;
	}

}
