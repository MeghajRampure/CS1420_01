package assign05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests to check the correctness of the CalendarDate class.
 * 
 * @author CS 1420 course staff and Meghaj Rampure
 * @version Sep 29 2026
 */
public class CalendarDateTest {
	// -------------------------------------------------------------------------
	// Provided tests
	// -------------------------------------------------------------------------
	
	@Test
	public void testGetDay() {
		CalendarDate date = new CalendarDate(3, 15, 1950);
		assertEquals(15, date.getDay(), "getDay method incorrect");
	}
	
	@Test
	public void testToString() {
		CalendarDate date = new CalendarDate(8, 1, 1970);
		assertEquals("August 1, 1970", date.toString(),
				"toString does not return correct String -- check for typos");
	}
	
	@Test
	public void testComesBeforeTrue() {
		CalendarDate date = new CalendarDate(5, 19, 1985);
		assertTrue(date.comesBefore(new CalendarDate(6, 9, 1985)),
				"comesBefore does not return true when date on which method is called comes before argument");
	}
	
	@Test
	public void testComesAfterSameDate() {
		CalendarDate date = new CalendarDate(2, 7, 1888);
		assertFalse(date.comesAfter(new CalendarDate(2, 7, 1888)),
				"comesAfter does not return false when date on which method is called is the same as argument");
	}
	
	@Test
	public void testAdvanceOneDayEndOfMonth() {
		CalendarDate date = new CalendarDate(4, 30, 1200);
		date.advanceOneDay();
		assertEquals(5, date.getMonth().getMonthNumber(),
				"advanceOneDay does not add 1 to month when at the end of the month");
		assertEquals(1, date.getDay(),
				"advanceOneDay does set day to 1 when at the end of the month");
		assertEquals(1200, date.getYear(),
				"advanceOneDay changed year when at the end of the month (not December)");
	}
	
	@Test
	public void testDayOfYearFirst() {
		CalendarDate date = new CalendarDate(1, 1, 3000);
		assertEquals(1, date.dayOfYear(), "dayOfYear does not return 1 for the first day of a year");
	}
	
	@Test
	public void testIsLeapYearTrue() {
		CalendarDate date = new CalendarDate(1, 1, 2004);
		assertTrue(date.isLeapYear(), "isLeapYear does not return true for year divisible by 4 but not 100");
	}
	
	@Test
	public void testEqualsTrue() {
		CalendarDate date = new CalendarDate(10, 10, 3333);
		assertTrue(date.equals(new CalendarDate(10, 10, 3333)),
				"equals method does not return true for same dates");
	}
	
	// -------------------------------------------------------------------------
	// Student-supplied tests
	// -------------------------------------------------------------------------

	@Test
	public void testNoParameterConstructor() {
		CalendarDate date = new CalendarDate();

		assertEquals(1, date.getMonth().getMonthNumber());
		assertEquals(1, date.getDay());
		assertEquals(1000, date.getYear());
	}

	@Test
	public void testGetMonth() {
		CalendarDate date = new CalendarDate(7, 20, 2026);

		assertEquals(new Month(7), date.getMonth());
	}

	@Test
	public void testGetYear() {
		CalendarDate date = new CalendarDate(7, 20, 2026);

		assertEquals(2026, date.getYear());
	}

	@Test
	public void testComesBeforeFalseSameDate() {
		CalendarDate date = new CalendarDate(5, 19, 1985);

		assertFalse(date.comesBefore(new CalendarDate(5, 19, 1985)));
	}

	@Test
	public void testComesBeforeDifferentYear() {
		CalendarDate date = new CalendarDate(12, 31, 2025);

		assertTrue(date.comesBefore(new CalendarDate(1, 1, 2026)));
	}

	@Test
	public void testComesBeforeDifferentMonth() {
		CalendarDate date = new CalendarDate(4, 30, 2026);

		assertTrue(date.comesBefore(new CalendarDate(5, 1, 2026)));
	}

	@Test
	public void testComesBeforeDifferentDay() {
		CalendarDate date = new CalendarDate(5, 1, 2026);

		assertTrue(date.comesBefore(new CalendarDate(5, 2, 2026)));
	}

	@Test
	public void testComesAfterTrue() {
		CalendarDate date = new CalendarDate(6, 9, 1985);

		assertTrue(date.comesAfter(new CalendarDate(5, 19, 1985)));
	}

	@Test
	public void testComesAfterFalse() {
		CalendarDate date = new CalendarDate(5, 19, 1985);

		assertFalse(date.comesAfter(new CalendarDate(6, 9, 1985)));
	}

	@Test
	public void testAdvanceOneDayNormal() {
		CalendarDate date = new CalendarDate(9, 23, 2026);

		date.advanceOneDay();

		assertEquals(9, date.getMonth().getMonthNumber());
		assertEquals(24, date.getDay());
		assertEquals(2026, date.getYear());
	}

	@Test
	public void testAdvanceOneDayDecember() {
		CalendarDate date = new CalendarDate(12, 31, 2026);

		date.advanceOneDay();

		assertEquals(1, date.getMonth().getMonthNumber());
		assertEquals(1, date.getDay());
		assertEquals(2027, date.getYear());
	}

	@Test
	public void testAdvanceOneDayFebruaryLeapYear() {
		CalendarDate date = new CalendarDate(2, 28, 2024);

		date.advanceOneDay();

		assertEquals(2, date.getMonth().getMonthNumber());
		assertEquals(29, date.getDay());
	}

	@Test
	public void testAdvanceOneDayFebruaryNonLeapYear() {
		CalendarDate date = new CalendarDate(2, 28, 2025);

		date.advanceOneDay();

		assertEquals(3, date.getMonth().getMonthNumber());
		assertEquals(1, date.getDay());
	}

	@Test
	public void testDayOfYearEndOfJanuary() {
		CalendarDate date = new CalendarDate(1, 31, 2026);

		assertEquals(31, date.dayOfYear());
	}

	@Test
	public void testDayOfYearEndOfFebruaryNonLeapYear() {
		CalendarDate date = new CalendarDate(2, 28, 2025);

		assertEquals(59, date.dayOfYear());
	}

	@Test
	public void testDayOfYearEndOfFebruaryLeapYear() {
		CalendarDate date = new CalendarDate(2, 29, 2024);

		assertEquals(60, date.dayOfYear());
	}

	@Test
	public void testDayOfYearSeptember23() {
		CalendarDate date = new CalendarDate(9, 23, 2026);

		assertEquals(266, date.dayOfYear());
	}

	@Test
	public void testIsLeapYearFalse() {
		CalendarDate date = new CalendarDate(1, 1, 2025);

		assertFalse(date.isLeapYear());
	}

	@Test
	public void testIsLeapYearCenturyFalse() {
		CalendarDate date = new CalendarDate(1, 1, 1900);

		assertFalse(date.isLeapYear());
	}

	@Test
	public void testIsLeapYearCenturyTrue() {
		CalendarDate date = new CalendarDate(1, 1, 2000);

		assertTrue(date.isLeapYear());
	}

	@Test
	public void testEqualsFalseDifferentMonth() {
		CalendarDate date = new CalendarDate(5, 10, 2026);

		assertFalse(date.equals(new CalendarDate(6, 10, 2026)));
	}

	@Test
	public void testEqualsFalseDifferentDay() {
		CalendarDate date = new CalendarDate(5, 10, 2026);

		assertFalse(date.equals(new CalendarDate(5, 11, 2026)));
	}

	@Test
	public void testEqualsFalseDifferentYear() {
		CalendarDate date = new CalendarDate(5, 10, 2026);

		assertFalse(date.equals(new CalendarDate(5, 10, 2027)));
	}

	@Test
	public void testEqualsNonCalendarDate() {
		CalendarDate date = new CalendarDate(5, 10, 2026);

		assertFalse(date.equals("May 10, 2026"));
	}}