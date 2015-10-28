package com.jove.domain.service;

import java.io.Serializable;

public class IncrementadorService implements Serializable {
	private static final long serialVersionUID = -1495057377596945928L;

	/**
	 * Retorna o número incrementado em 1
	 * @param numero a incrementar
	 */
	public int getNumeroIncrementadoEmUm(int numero) {
		return numero + 1;
	}
}