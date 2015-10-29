package com.jove.domain.model;

import com.jove.endereco.Endereco;

public class Frete {

	private Endereco origem;
	private Endereco destino;
	private double peso;
	private double valor;

	/**
	 * @return the origem
	 */
	public Endereco getOrigem() {
		return origem;
	}

	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(Endereco origem) {
		this.origem = origem;
	}

	/**
	 * @return the destino
	 */
	public Endereco getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Endereco destino) {
		this.destino = destino;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	/**
	 * Informa ao usuário o valor do frete
	 * @author Nicolas Ibanheiz | 28/08/2015
	 */
	public void informarCalculo() {
		System.out.println("O valor do frete é: R$" + valor);
	}

}
