package com.jove.web.bean;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jove.domain.model.Cliente;

@Named
@ApplicationScoped
public class ApplicationBeanCliente implements Serializable {
	private static final long serialVersionUID = 1648423330455802667L;
	
	@Inject
	private Cliente cliente;
	
	

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
