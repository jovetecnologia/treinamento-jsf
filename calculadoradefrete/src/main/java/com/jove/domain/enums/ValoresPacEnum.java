package com.jove.domain.enums;

public enum ValoresPacEnum {

	DENTRO_MUNICIPIO(10.0),
	DENTRO_REGIAO(14.0),
	DENTRO_UF(18.0),
	FORA_UF(27.0);
	
	private double valorFrete;

	private ValoresPacEnum(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	/**
	 * @return the valorFrete
	 */
	public double getValorFrete() {
		return valorFrete;
	}
}
