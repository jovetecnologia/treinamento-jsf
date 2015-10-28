package com.jove.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jove.domain.model.Numero;
import com.jove.domain.service.IncrementadorService;

@Named
@RequestScoped
public class RequestBean implements Serializable {
	private static final long serialVersionUID = 3033306650473109923L;
	
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