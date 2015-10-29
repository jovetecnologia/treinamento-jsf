package com.jove.domain.model;

public class FreteNull extends Frete {
	@Override
	public void informarCalculo() {
		System.out.println("Não foi possível definir um frete com os valores informados");
	}
}
