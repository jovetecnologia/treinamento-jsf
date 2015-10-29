package com.jove.domain.enums;

public enum TipoServicoEnum {

	PAC(1),
	SEDEX(2),
	SEDEX10(3);
	
	private int servico;

	private TipoServicoEnum(int servico) {
		this.servico = servico;
	}
	
	/**
	 * @author Nicolas Ibanheiz | 28/08/2015
	 * @param valorServico numero inteiro que representa o serviço
	 * @return Enum do tipo de serviço selecionado
	 */
	public static TipoServicoEnum recuperarServico(int valorServico) {
		for (TipoServicoEnum servico : values()) {
			if (servico.getServico() == valorServico) {
				return servico;
			}
		}
		return null;
	}

	/**
	 * @return the servico
	 */
	public int getServico() {
		return servico;
	}
	
	
}
