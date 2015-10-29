package com.jove.infrastructure.util.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="dateConverter")
public class DateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2 == null || arg2.equals("")) { return null; } 
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date data = sdf.parse(arg2);
			return data;
		} catch (ParseException e) {e.printStackTrace();}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null) { return null; }
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(arg2);
		return data;
	}
}