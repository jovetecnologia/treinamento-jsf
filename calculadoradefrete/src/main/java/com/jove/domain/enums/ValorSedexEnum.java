package com.jove.domain.enums;

public enum ValorSedexEnum {

	KG(1.5), DENTRO_UF(20.0), FORA_UF(28.8);

	private double valor;

	private ValorSedexEnum(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

}
