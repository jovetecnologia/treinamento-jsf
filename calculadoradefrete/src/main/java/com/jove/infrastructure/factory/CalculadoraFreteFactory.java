package com.jove.infrastructure.factory;

import com.jove.domain.enums.TipoServicoEnum;
import com.jove.domain.model.CalculadoraFrete;
import com.jove.domain.model.CalculadoraFretePAC;
import com.jove.domain.model.CalculadoraFreteSedex;
import com.jove.domain.model.CalculadoraFreteSedex10;

public class CalculadoraFreteFactory {

	/**
	 * @author Nicolas Ibanheiz | 28/08/2015
	 * @param tipoServicoEnum
	 * @return Instância de CalculadoraFrete criada a partir do tipo de serviço
	 */
	public static CalculadoraFrete criarCalculadora(TipoServicoEnum tipoServicoEnum) {
		switch (tipoServicoEnum) {
		case PAC:
			return new CalculadoraFretePAC();

		case SEDEX:
			return new CalculadoraFreteSedex();

		case SEDEX10:
			return new CalculadoraFreteSedex10();

		default:
			break;
		}
		return null;
	}
}
