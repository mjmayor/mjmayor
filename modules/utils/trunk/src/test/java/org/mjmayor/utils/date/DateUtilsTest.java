package org.mjmayor.utils.date;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DateUtilsTest {

	private String FORMAT_1 = "dd/MM/yyyy HH:mm";
	private String FORMAT_2 = "yy-MM-d h:mm:ss";

	private Date date1;
	private Date date2;

	@Before
	public void setUp() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(1984, 02, 18, 14, 00);
		date1 = calendar.getTime();

		calendar.set(2013, 10, 04, 15, 01, 11);
		date2 = calendar.getTime();
	}

	@Test
	public void stringToDate1() throws ParseException {
		String stringDate = DateUtils.dateToString(date1, FORMAT_1);
		assertEquals(stringDate, "18/03/1984 14:00");
	}

	@Test
	public void stringToDate2() throws ParseException {
		String stringDate = DateUtils.dateToString(date2, FORMAT_2);
		assertEquals(stringDate, "13-11-4 3:01:11");
	}
}
