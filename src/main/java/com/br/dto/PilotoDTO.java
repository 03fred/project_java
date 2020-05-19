package com.br.dto;

import java.sql.Time;

public class PilotoDTO {

	private int id;
	private String nome;
	private String velocidadeMediaProva;
	private Time tempoMelhorVolta;
	private Time tempoTotalProva;
	private String tempoPosPrimeiroColocado;
	private int voltasCompletadas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getVelocidadeMediaProva() {
		return velocidadeMediaProva;
	}
	public void setVelocidadeMediaProva(String velocidadeMediaProva) {
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

	
}
