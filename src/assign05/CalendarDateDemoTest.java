package assign05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the CalendarDateDemo class.
 *
 * @author Meghaj Rampure
 * @version Sep 30 2026
 */
public class CalendarDateDemoTest {

    @Test
    public void testCountDatesBeforeAllBefore() {
        CalendarDate[] dates = {
                new CalendarDate(1, 1, 2026),
                new CalendarDate(2, 1, 2026),
                new CalendarDate(3, 1, 2026)
        };

        assertEquals(3,
                CalendarDateDemo.countDatesBefore(
                        dates, new CalendarDate(4, 1, 2026)));
    }

    @Test
    public void testCountDatesBeforeNoneBefore() {
        CalendarDate[] dates = {
                new CalendarDate(5, 1, 2026),
                new CalendarDate(6, 1, 2026),
                new CalendarDate(7, 1, 2026)
        };

        assertEquals(0,
                CalendarDateDemo.countDatesBefore(
                        dates, new CalendarDate(4, 1, 2026)));
    }

    @Test
    public void testCountDatesBeforeSomeBefore() {
        CalendarDate[] dates = {
                new CalendarDate(1, 1, 2026),
                new CalendarDate(5, 1, 2026),
                new CalendarDate(3, 1, 2026),
                new CalendarDate(8, 1, 2026)
        };

        assertEquals(2,
                CalendarDateDemo.countDatesBefore(
                        dates, new CalendarDate(4, 1, 2026)));
    }

    @Test
    public void testCountDatesBeforeSameDate() {
        CalendarDate[] dates = {
                new CalendarDate(4, 1, 2026),
                new CalendarDate(4, 1, 2026)
        };

        assertEquals(0,
                CalendarDateDemo.countDatesBefore(
                        dates, new CalendarDate(4, 1, 2026)));
    }

    @Test
    public void testCountDatesBeforeDifferentYears() {
        CalendarDate[] dates = {
                new CalendarDate(12, 31, 2025),
                new CalendarDate(1, 1, 2026),
                new CalendarDate(12, 31, 2026)
        };

        assertEquals(2,
                CalendarDateDemo.countDatesBefore(
                        dates, new CalendarDate(6, 1, 2026)));
    }

    @Test
    public void testCountDatesBeforeEmptyArray() {
        CalendarDate[] dates = {};

        assertEquals(0,
                CalendarDateDemo.countDatesBefore(
                        dates, new CalendarDate(1, 1, 2026)));
    }
}