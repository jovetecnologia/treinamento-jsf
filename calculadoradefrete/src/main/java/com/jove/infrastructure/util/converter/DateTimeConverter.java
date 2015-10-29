package com.jove.infrastructure.util.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="dateTimeConverter")
public class DateTimeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		try {
			return dateFormat.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return dateFormat.format((Date) value);
	}

}
