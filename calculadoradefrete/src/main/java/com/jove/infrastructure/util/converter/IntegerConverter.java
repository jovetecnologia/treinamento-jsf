package com.jove.infrastructure.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="integerConverter")
public class IntegerConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		try {
			return Integer.parseInt(arg2.replace(".", ""));
		} catch (java.lang.NumberFormatException e) {
			return "";
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {		
		return String.valueOf(arg2);
	}
}