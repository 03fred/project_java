package com.br.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.br.model.Volta;

public class DadosCorridaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Volta> detalhamentoVoltas = new ArrayList<Volta>();
	private List<PilotoDTO> melhorVoltaPiloto;
	private Volta melhorVoltaCorrida;

	public DadosCorridaDTO(List<Volta> listaVolta, List<PilotoDTO> listaMelhoresVoltasPiloto, Volta melhorVolta) {
		this.detalhamentoVoltas = listaVolta;
		this.melhorVoltaPiloto = listaMelhoresVoltasPiloto;
		this.melhorVoltaCorrida = melhorVolta;

	}

	public List<Volta> getDetalhamentoVoltas() {
		return detalhamentoVoltas;
	}

	public List<PilotoDTO> getMelhorVoltaPiloto() {
		return melhorVoltaPiloto;
	}

	public Volta getMelhorVoltaCorrida() {
		return melhorVoltaCorrida;
	}

	
}
