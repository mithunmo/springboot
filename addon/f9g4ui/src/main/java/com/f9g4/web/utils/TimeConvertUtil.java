package com.f9g4.web.utils;

import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.common.util.XMLGregorianCalendarConverter;

@Controller
@SessionAttributes({"timezoneOffset"})
public class TimeConvertUtil {

	private TimeConvertUtil() {}
	
	public static Calendar convertToLocalTime(Calendar source, Integer timezoneOffset)
	{
		/*Class<? extends Object> cls=source.getClass();
		System.out.println(cls.getName());
		//get the last part of class name
		String className=cls.getName().substring((cls.getName().lastIndexOf(".")+1));*/
		
		//Calendar time=Calendar.getInstance();
		source.add(Calendar.HOUR, -timezoneOffset); //convert to local time
		return source;
	}
	
	public static Date convertXMLDateToLocalTime(XMLGregorianCalendar source, Integer timezoneOffset)
	{
		/*Class<? extends Object> cls=source.getClass();
		System.out.println(cls.getName());
		//get the last part of class name
		String className=cls.getName().substring((cls.getName().lastIndexOf(".")+1));*/
		
		//Calendar time=Calendar.getInstance();
		Calendar temp=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(source);
		temp.add(Calendar.HOUR, -timezoneOffset); //convert to local time
		return temp.getTime();
	}

	public static XMLGregorianCalendar convertToLocalTime(XMLGregorianCalendar source, Integer timezoneOffset)
	{
		Calendar time=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(source);
		time.add(Calendar.HOUR, -timezoneOffset); //convert to local time
		try {
			return XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(time);
		} catch (DatatypeConfigurationException e) {
			return null;
		}
	}
	
	public static XMLGregorianCalendar convertToLocalTime(XMLGregorianCalendar source, Integer timezoneOffset, Integer hrsOffset)
	{
		Calendar time=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(source);
		time.add(Calendar.HOUR, -timezoneOffset+hrsOffset); //convert to local time
		try {
			return XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(time);
		} catch (DatatypeConfigurationException e) {
			return null;
		}
	}
}
