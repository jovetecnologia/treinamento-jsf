package com.jove.domain.enums;

public enum ValorSedex10Enum {

	KG(1.8), VALOR_FIXO(30);

	private double valor;

	private ValorSedex10Enum(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

}
