package com.br.model;

import java.sql.Time;

public class Piloto {

	private int id;
	private String nome;
	private String velocidadeMedia;
	private Time tempoTotalProva;
	private String tempoPosPrimeiroColocado;

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

	public String getVelocidadeMediaProva() {
		return velocidadeMedia;
	}

	public void setVelocidadeMediaProva(String velocidadeMediaProva) {
		this.velocidadeMedia = velocidadeMediaProva;
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
