package assign07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateSearchTest {

    @Test
    public void testSequentialSearchFirst() {
        Candidate first = new Candidate("Alex", 20, 5);

        Candidate[] array = {
                first,
                new Candidate("Blake", 25, 7),
                new Candidate("Zoey", 21, 9)
        };

        Candidate result = CandidateSearch.sequentialSearch(
                array, new Candidate("Alex", 20));

        assertSame(first, result);
        assertEquals(1, CandidateSearch.getCallCount());
    }

    @Test
    public void testSequentialSearchLast() {
        Candidate last = new Candidate("Zoey", 21, 9);

        Candidate[] array = {
                new Candidate("Alex", 20, 5),
                new Candidate("Blake", 25, 7),
                last
        };

        Candidate result = CandidateSearch.sequentialSearch(
                array, new Candidate("Zoey", 21));

        assertSame(last, result);
        assertEquals(3, CandidateSearch.getCallCount());
    }

    @Test
    public void testSequentialSearchNotFound() {
        Candidate[] array = {
                new Candidate("Alex", 20, 5),
                new Candidate("Blake", 25, 7),
                new Candidate("Zoey", 21, 9)
        };

        Candidate result = CandidateSearch.sequentialSearch(
                array, new Candidate("Taylor", 22));

        assertNull(result);
        assertEquals(4, CandidateSearch.getCallCount());
    }


}
