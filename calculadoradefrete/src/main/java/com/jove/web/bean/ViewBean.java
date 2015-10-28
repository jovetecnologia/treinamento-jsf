package com.jove.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jove.domain.model.Numero;
import com.jove.domain.service.IncrementadorService;

@Named
@ViewScoped
public class ViewBean implements Serializable {
	private static final long serialVersionUID = -1938630150671734466L;
	
	@Inject
	private Numero numero;
	
	@Inject
	private IncrementadorService incrementadorService;
	
	@PostConstruct
	public void inicializar() {
		numero.setValor(1);
	}
	
	/**
	 * Incrementa em 1 a variável número
	 */
	public void incrementarNumero() {
		numero.setValor(incrementadorService.getNumeroIncrementadoEmUm(numero.getValor()));
	}

	/**
	 * @return the numero
	 */
	public Numero getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Numero numero) {
		this.numero = numero;
	}
}