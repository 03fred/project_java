package com.br.dto;

import java.util.List;

import com.br.model.Volta;

public class RanqueamentoDTO {

	private List<Volta> listaVoltas;
	private List<Volta> listaMelhorVoltaPorPiloto;
	private Volta melhorVolta;

	public RanqueamentoDTO(List<Volta> listaVoltas, List<Volta> listaMelhorVoltaPorPiloto, Volta melhorVolta) {

		this.listaMelhorVoltaPorPiloto = listaMelhorVoltaPorPiloto;
		this.listaVoltas = listaVoltas;
		this.melhorVolta = melhorVolta;

	}
	
	
}
