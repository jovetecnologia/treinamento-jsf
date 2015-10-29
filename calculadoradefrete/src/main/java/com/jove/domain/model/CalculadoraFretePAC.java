package com.jove.domain.model;

import com.jove.domain.enums.ValoresPacEnum;
import com.jove.endereco.Endereco;

public class CalculadoraFretePAC extends CalculadoraFrete {

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

		if (origem.getCidade().equals(destino.getCidade())) {
			frete.setValor(ValoresPacEnum.DENTRO_MUNICIPIO.getValorFrete());
		} else if (origem.getCidade().getRegiao().equals(destino.getCidade().getRegiao())) {
			frete.setValor(ValoresPacEnum.DENTRO_REGIAO.getValorFrete());
		} else if (origem.getCidade().getUfCidade().equals(destino.getCidade().getUfCidade())) {
			frete.setValor(ValoresPacEnum.DENTRO_UF.getValorFrete());
		} else {
			frete.setValor(ValoresPacEnum.FORA_UF.getValorFrete());
		}
		
		return frete;
	}
}
