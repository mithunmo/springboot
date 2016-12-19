package com.f9g4.common.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLGregorianCalendarConverter {
	
	public static Calendar convertXMLGregorianCalendarToCalendar(XMLGregorianCalendar xmlGregorianCalendar) {
		if(xmlGregorianCalendar == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
		return calendar;
	}
	
	public static XMLGregorianCalendar convertCalendarToXMLGregorianCalendar(Calendar calendar) throws DatatypeConfigurationException{
		if(calendar == null)
			return null;
		GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
		gregorianCalendar.setTimeInMillis(calendar.getTimeInMillis());
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		return xmlGregorianCalendar;
	}

}
