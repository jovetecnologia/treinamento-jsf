package com.jove.domain.model;

import java.util.Locale;

import com.jove.domain.enums.ValorSedex10Enum;
import com.jove.endereco.Endereco;

public class CalculadoraFreteSedex10 extends CalculadoraFrete {

	@Override
	public Frete calcular(String cepOrigem, String cepDestino, double peso) {
		Frete frete = new Frete();
		Endereco origem = enderecoService.buscarEndereco(cepOrigem);
		Endereco destino = enderecoService.buscarEndereco(cepDestino);

		if (!isPossivelCriarFreteComEnderecos(origem, destino)) {
			return new FreteNull();
		}

		frete.setOrigem(origem);
		frete.setDestino(destino);
		frete.setPeso(peso);
		double valorFrete = ValorSedex10Enum.VALOR_FIXO.getValor() + (peso * ValorSedex10Enum.KG.getValor());
		frete.setValor(Double.valueOf(String.format(Locale.US, "%.2f", Math.floor(valorFrete))));
		
		return frete;
	}
}
