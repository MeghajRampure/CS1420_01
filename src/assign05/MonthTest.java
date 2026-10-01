package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests to check the correctness of the Month class.
 * 
 * @author CS 1420 course staff and Meghaj Rampure
 * @version Sep 29 2026
 */
public class MonthTest {
	// -------------------------------------------------------------------------
	// Provided tests
	// -------------------------------------------------------------------------

	@Test
	public void testNoParameterConstructor() {
		Month jan = new Month();
		assertEquals(1, jan.getMonthNumber(), "No-parameter constructor does not set month number to 1");
	}
	
	@Test
	public void testToString() {
		Month oct = new Month(10);
		assertEquals("October", oct.toString(), "toString does not return correct String -- check for typos");
	}
	
	@Test
	public void testLastDayFebruaryLeapYear() {
		Month feb = new Month(2);
		assertEquals(29, feb.lastDay(true), "Last day of February is incorrect for a leap year");
	}
	
	@Test
	public void testLastDayApril() {
		Month apr = new Month(4);
		assertEquals(30, apr.lastDay(false), "Last day of April is incorrect");
	}
	
	@Test
	public void testLastDayMay() {
		Month may = new Month(5);
		assertEquals(31, may.lastDay(false), "Last day of May is incorrect");
	}
	
	@Test
	public void testValidDayNormal() {
		Month jun = new Month(6);
		assertTrue(jun.validDay(10, false), "validDay incorrect for valid day");
	}
	
	@Test
	public void testValidDayFebruaryLeapYear() {
		Month feb = new Month(2);
		assertTrue(feb.validDay(29, true), "validDay incorrect for leap year February");
	}
	
	@Test
	public void testEqualsFalse() {
		Month sep = new Month(9);
		assertFalse(sep.equals(new Month(8)),
				"equals method does not return false when passed Month object that is the different");
	}
	
	@Test
	public void testEqualsNonMonth() {
		Month mar = new Month(3);
		assertFalse(mar.equals(new Scanner(System.in)),
				"equals method does not return false when passed a non-Month object");
	}
	
	// -------------------------------------------------------------------------
	// Student-supplied tests
	// -------------------------------------------------------------------------

	@Test
	public void testParameterizedConstructor() {
		Month month = new Month(7);
		assertEquals(7, month.getMonthNumber());
	}

	@Test
	public void testLastDayJanuary() {
		Month month = new Month(1);
		assertEquals(31, month.lastDay(false));
	}

	@Test
	public void testLastDayFebruaryNonLeapYear() {
		Month month = new Month(2);
		assertEquals(28, month.lastDay(false));
	}

	@Test
	public void testLastDayJune() {
		Month month = new Month(6);
		assertEquals(30, month.lastDay(false));
	}

	@Test
	public void testLastDayDecember() {
		Month month = new Month(12);
		assertEquals(31, month.lastDay(false));
	}

	@Test
	public void testValidDayFirstDay() {
		Month month = new Month(1);
		assertTrue(month.validDay(1, false));
	}

	@Test
	public void testValidDayLastDay() {
		Month month = new Month(4);
		assertTrue(month.validDay(30, false));
	}

	@Test
	public void testInvalidDayZero() {
		Month month = new Month(4);
		assertFalse(month.validDay(0, false));
	}

	@Test
	public void testInvalidDayTooLarge() {
		Month month = new Month(4);
		assertFalse(month.validDay(31, false));
	}

	@Test
	public void testFebruaryInvalidDayNonLeapYear() {
		Month month = new Month(2);
		assertFalse(month.validDay(29, false));
	}

	@Test
	public void testFebruaryInvalidDayLeapYear() {
		Month month = new Month(2);
		assertFalse(month.validDay(30, true));
	}

	@Test
	public void testToStringJanuary() {
		assertEquals("January",
				new Month(1).toString());
	}

	@Test
	public void testToStringDecember() {
		assertEquals("December",
				new Month(12).toString());
	}

	@Test
	public void testEqualsTrue() {
		assertTrue(new Month(5).
				equals(new Month(5)));
	}




}