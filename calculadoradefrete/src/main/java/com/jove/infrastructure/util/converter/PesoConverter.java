package com.jove.infrastructure.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="pesoConverter")
public class PesoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(null == arg2 ||  "".equals(arg2)) {
			arg2 = "0,0";
		}
		double peso = Double.parseDouble(arg2.replace(".", "").replace(",", "."));
		return peso;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(null == arg2 || "".equals(arg2.toString().trim()) || "0".equals(arg2.toString().trim())) {
			arg2 = "0.0";			
		}
		String peso = String.valueOf(arg2).replace(".", ",");		
		if(peso.contains(",")) {
			peso += "000";
			peso = peso.substring(0, peso.indexOf(",") + 4);
		}
		
		String quilos = peso.split(",")[0];
		String gramas = peso.split(",")[1];
		StringBuilder valor = new StringBuilder();
		for(int i = quilos.length() - 1, y = 0; i >= 0; i--, y++) {
			if(y % 3 == 0 && y != 0) {
				valor.append(".");
			}
			valor.append(quilos.charAt(i));
		}
		return inverterString(valor.charAt(0) == '.' ? valor.substring(1, valor.length()) : valor.toString()) + "," + gramas;
	}	
	
	/**
	 * Inverte a cadeia de caracteres
	 * @param valor
	 * @return String invertida
	 */
	private String inverterString(String valor) {
		String retorno = "";
		for(int i = valor.length() - 1; i >= 0; i--) {
			retorno += valor.charAt(i);
		}
		return retorno;
	}
	
	/**
	 * Formata o valor informado, aplicando a máscara deste converter
	 * @param valor a formatar
	 * @return String formatada
	 */
	public String formatar(double valor) {
		return getAsString(null, null, valor);
	}
}