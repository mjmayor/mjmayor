package org.mjmayor.utils.date;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DateUtilsTest {

	private static final String DATE_FORMAT_1 = "dd/MM/yyyy HH:mm";
	private static final String DATE_FORMAT_2 = "yy-MM-d h:mm:ss a";

	private Date date1;
	private Date date2;

	private String stringDate1;
	private String stringDate2;

	@Before
	public void setUp() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(1984, 02, 18, 14, 00, 00);
		date1 = calendar.getTime();

		calendar.set(2013, 10, 04, 15, 01, 11);
		date2 = calendar.getTime();

		stringDate1 = "18/03/1984 14:00";
		stringDate2 = "13-11-4 3:01:11 PM";
	}

	@Test
	public void stringToDate1() throws ParseException {
		Date date = DateUtils.stringToDate(stringDate1, DATE_FORMAT_1);
		long time = date1.getTime() / 1000 * 1000;
		assertEquals(date.getTime(), time);
	}

	@Test
	public void stringToDate2() throws ParseException {
		Date date = DateUtils.stringToDate(stringDate2, DATE_FORMAT_2);
		long time = date2.getTime() / 1000 * 1000;
		assertEquals(date.getTime(), time);
	}

	@Test
	public void dateToString1() throws ParseException {
		String stringDate = DateUtils.dateToString(date1, DATE_FORMAT_1);
		assertEquals(stringDate, "18/03/1984 14:00");
	}

	@Test
	public void dateToString2() throws ParseException {
		String stringDate = DateUtils.dateToString(date2, DATE_FORMAT_2);
		assertEquals(stringDate, "13-11-4 3:01:11 PM");
	}

	@Test
	public void convertDate1() throws ParseException {
		String stringDate = DateUtils.convertDate(stringDate1, DATE_FORMAT_1, DATE_FORMAT_2);
		assertEquals(stringDate, "84-03-18 2:00:00 PM");
	}
	
	@Test
	public void convertDate2() throws ParseException {
		String stringDate = DateUtils.convertDate(stringDate2, DATE_FORMAT_2, DATE_FORMAT_1);
		assertEquals(stringDate, "04/11/2013 15:01");
	}
}
