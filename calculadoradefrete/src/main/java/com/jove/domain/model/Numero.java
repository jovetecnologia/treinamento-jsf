package com.jove.domain.model;

import java.io.Serializable;

public class Numero implements Serializable {
	private static final long serialVersionUID = 544292131402548291L;
	
	private int valor;
	
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getValor();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numero other = (Numero) obj;
		if (getValor() != other.getValor())
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getValor());
	}
}