package com.br.model;

import java.sql.Time;

public class Piloto {

	private int id;
	private String nome;
	private double velocidadeMedia;
	private String velocidadeMediaProva;
	private Time tempoMelhorVolta;


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


	public Time getTempoMelhorVolta() {
		return tempoMelhorVolta;
	}

	public void setTempoMelhorVolta(Time tempoMelhorVolta) {
		this.tempoMelhorVolta = tempoMelhorVolta;
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
