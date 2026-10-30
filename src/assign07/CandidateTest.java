package assign07;

/**
 * Runs all necessary tests for the Candidate class
 *
 * @author Meghaj Rampure
 * @version 10/29/26
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateTest {
    @Test
    public void testConstructor() {
        Candidate candidate = new Candidate("Zoey", 21, 7);

        assertEquals(7, candidate.getRating());
        assertEquals("Zoey(21)", candidate.toString());
    }

    @Test
    public void testConstructorWithoutRating() {
        Candidate candidate = new Candidate("Zoey", 21);

        assertEquals(1, candidate.getRating());
    }

    @Test
    public void testInvalidAge() {
        boolean exceptionThrown = false;

        try {
            new Candidate("Zoey", -1, 7);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    @Test
    public void testCompareToName() {
        Candidate first = new Candidate("Adam", 20, 5);
        Candidate second = new Candidate("Zoey", 20, 5);

        assertTrue(first.compareTo(second) < 0);
        assertTrue(second.compareTo(first) > 0);
    }
    @Test
    public void testEqualsNull() {
        Candidate candidate = new Candidate("Alex", 20, 5);
        assertFalse(candidate.equals(null));
    }
    @Test
    public void testToString() {
        Candidate candidate = new Candidate("Zoey", 21, 7);

        assertEquals("Zoey(21)", candidate.toString());
    }
}
