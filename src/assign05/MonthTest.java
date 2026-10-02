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
	public void testLastDayMarch() {
		Month month = new Month(3);
		assertEquals(31, month.lastDay(false));
	}

	@Test
	public void testLastDayJuly() {
		Month month = new Month(7);
		assertEquals(31, month.lastDay(false));
	}

	@Test
	public void testLastDayAugust() {
		Month month = new Month(8);
		assertEquals(31, month.lastDay(false));
	}

	@Test
	public void testLastDaySeptember() {
		Month month = new Month(9);
		assertEquals(30, month.lastDay(false));
	}

	@Test
	public void testLastDayOctober() {
		Month month = new Month(10);
		assertEquals(31, month.lastDay(false));
	}

	@Test
	public void testLastDayNovember() {
		Month month = new Month(11);
		assertEquals(30, month.lastDay(false));
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
	public void testValidDayZero() {
		Month month = new Month(4);
		assertFalse(month.validDay(0, false));
	}

	@Test
	public void testValidDayTooLarge() {
		Month month = new Month(4);
		assertFalse(month.validDay(31, false));
	}

	@Test
	public void testValidDayFebruaryNonLeapYear() {
		Month month = new Month(2);
		assertFalse(month.validDay(29, false));
	}

	@Test
	public void testValidDayJanuary31() {
		Month month = new Month(1);
		assertTrue(month.validDay(31, false));
	}

	@Test
	public void testInvalidDayJanuary32() {
		Month month = new Month(1);
		assertFalse(month.validDay(32, false));
	}

	@Test
	public void testToStringJanuary() {
		Month month = new Month(1);
		assertEquals("January", month.toString());
	}

	@Test
	public void testToStringDecember() {
		Month month = new Month(12);
		assertEquals("December", month.toString());
	}

	@Test
	public void testToStringFebruary() {
		Month month = new Month(2);
		assertEquals("February", month.toString());
	}

	@Test
	public void testToStringJuly() {
		Month month = new Month(7);
		assertEquals("July", month.toString());
	}

	@Test
	public void testEqualsTrue() {
		Month month = new Month(5);
		assertTrue(month.equals(new Month(5)));
	}

}