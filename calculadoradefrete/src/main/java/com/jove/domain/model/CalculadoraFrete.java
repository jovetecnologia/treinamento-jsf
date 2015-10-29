package com.jove.domain.model;

import com.jove.endereco.Endereco;
import com.jove.endereco.EnderecoService;

public abstract class CalculadoraFrete {

	protected EnderecoService enderecoService;
	
	public CalculadoraFrete() {
		enderecoService = new EnderecoService();
	}
	
	/**
	 * @author Nicolas Ibanheiz | 28/08/2015
	 * @param cepOrigem Origem da viagem
	 * @param cepDestino Final da viagem
	 * @param peso da mercadoria
	 * @return Frete composto com os valores dependendo do tipo de serviço selecionado
	 */
	public abstract Frete calcular(String cepOrigem, String cepDestino, double peso);
	
	/**
	 * @author Nicolas Ibanheiz | 28/08/2015
	 * @param origem
	 * @param destino
	 * @return <b>true</b> se for possível criar o frete
	 */
	public boolean isPossivelCriarFreteComEnderecos(Endereco origem, Endereco destino) {
		if (origem == null || destino == null) {
			return false;
		}
		return true;
	}
}
