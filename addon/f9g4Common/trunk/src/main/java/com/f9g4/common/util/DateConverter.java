package com.f9g4.common.util;

import java.util.Calendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

public class DateConverter implements CustomConverter {

	public Object convert(Object destination, Object source, @SuppressWarnings("rawtypes") Class destClass,
			@SuppressWarnings("rawtypes") Class sourceClass) {
		if (source == null) {
			return null;
		}
		XMLGregorianCalendar dest = null;

		if (source != null && source instanceof XMLGregorianCalendar) {
			// check to see if the object already exists

			dest = mapDate((XMLGregorianCalendar) source);
			return dest;
		} else {
			throw new MappingException("Converter used incorrectly. Arguments passed in were:" + destination + " and " + source);
		}
	}

	/*
	 * private XMLGregorianCalendar mapDate(DateTime date) { if (date == null) {
	 * return null; } GregorianCalendar gc = new GregorianCalendar();
	 * gc.setTime(date.toDate()); try { return
	 * DatatypeFactory.newInstance().newXMLGregorianCalendar(gc); } catch
	 * (DatatypeConfigurationException e) { throw new RuntimeException(e); } }
	 */

	private XMLGregorianCalendar mapDate(XMLGregorianCalendar date) {
		if (date == null) {
			return null;
		}
		return (XMLGregorianCalendar) date.clone();
		
	}
	
	  public  static XMLGregorianCalendar toXMLCalendar(Calendar calandar ){
	        XMLGregorianCalendar xmlCalendar =    null;
	        try {
	            DatatypeFactory dtf = DatatypeFactory.newInstance();
	            xmlCalendar = dtf.newXMLGregorianCalendar();
	            xmlCalendar.setYear(calandar.get(Calendar.YEAR));
	            xmlCalendar.setDay(calandar.get(Calendar.DAY_OF_MONTH));
	            xmlCalendar.setMonth(calandar.get(Calendar.MONTH)+ 1);
	            xmlCalendar.setHour(calandar.get(Calendar.HOUR_OF_DAY));
	            xmlCalendar.setMinute(calandar.get(Calendar.    MINUTE));
	            xmlCalendar.setSecond(calandar.get(Calendar.    SECOND));
	            xmlCalendar.setMillisecond(calandar.get(Calendar.MILLISECOND));
	            int offsetInMinutes = (calandar.get(Calendar.ZONE_OFFSET) + calandar.get(Calendar.DST_OFFSET)) / (60 * 1000);
	            xmlCalendar.setTimezone(offsetInMinutes);

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return    xmlCalendar;

	    }
	  
	  public static int GetExpiredMonths(Calendar expirationDate) {
			// TODO Auto-generated method stub
			Calendar curTime = Calendar.getInstance();
			Calendar comparedTime=(Calendar) expirationDate.clone();
			int noodMonths = 0;
			while(true)
			{
				if(comparedTime.before(curTime))
				{
					comparedTime.add(Calendar.MONTH, 1);
					noodMonths++;
				}
				else
					break;
			}
			return noodMonths;
		}

}
