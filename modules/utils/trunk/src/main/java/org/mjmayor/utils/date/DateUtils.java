package org.mjmayor.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase con utilidades para fechas
 * 
 * @author Manuel Jose Mayor Perez
 * @date 4/11/2013
 */
public class DateUtils {

	public static String dateToString(Date date, String format) throws ParseException {
		SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date stringToDate(String stringDate, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(stringDate);
		return date;
	}

	public static String convertDate(String stringDate, String oldFormat, String newFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
		Date date = sdf.parse(stringDate);
		sdf.applyPattern(newFormat);
		return sdf.format(date);
	}
}
