package com.jove.domain.model;

import com.jove.domain.enums.ValorSedexEnum;
import com.jove.endereco.Endereco;

public class CalculadoraFreteSedex extends CalculadoraFrete {

	@Override
	public Frete calcular(String cepOrigem, String cepDestino, double peso) {
		Frete frete = new Frete();
		double valorFrete = 0.0;
		Endereco origem = enderecoService.buscarEndereco(cepOrigem);
		Endereco destino = enderecoService.buscarEndereco(cepDestino);
		
		if (!isPossivelCriarFreteComEnderecos(origem, destino)) {
			return new FreteNull();
		}

		frete.setOrigem(origem);
		frete.setDestino(destino);
		frete.setPeso(peso);
		
		valorFrete = peso * ValorSedexEnum.KG.getValor();
		
		if (origem.getCidade().getUfCidade().equals(destino.getCidade().getUfCidade())) {
			valorFrete += ValorSedexEnum.DENTRO_UF.getValor();
		} else {
			valorFrete += ValorSedexEnum.FORA_UF.getValor();
		}
		
		frete.setValor(valorFrete);
		
		return frete;
	}
}
