package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests to check the correctness of the Word class.
 * 
 * @author CS 1420 course staff and Meghaj Rampure
 * @version October 8, 2026
 */
public class WordTest {
	// Provided
	@Test
	public void testFirstConstructorException() {
		assertThrows(IllegalArgumentException.class, () -> { new Word("hel!o"); });
	}
	
	// Provided
	@Test
	public void testSecondConstructorException() {
		assertThrows(IllegalArgumentException.class, () -> 
			{ new Word(new char[] { 'W', 'h', 'o', '?' }); });
	}
	
	// Provided
	@Test
	public void testToStringNormal() {
		Word normal = new Word("Normal");
		assertEquals("Normal", normal.toString());
	}
	// New
	@Test
	public void testForEmptyWord(){
		Word empty = new Word("");
		assertEquals("", empty.toString());

	}

	// Provided
	@Test
	public void testCountOccurrencesOneLetter() {		
		Word oneLetter = new Word("a");
		assertEquals(1, oneLetter.countOccurrences('a'));
	}
	
	// Provided
	@Test
	public void testIsCountOccurrencesMultiple() {
		Word multiplePs = new Word("saippuakivikauppias");
		assertEquals(4, multiplePs.countOccurrences('p'));
	}
	// New
	@Test
	public void testCountOccurrencesNotFound() {
		Word word = new Word("hello");
		assertEquals(0, word.countOccurrences('z'));
	}
	// New
	@Test
	public void testCountOccurrencesCaseSensitive() {
		Word word = new Word("HeLLo");
		assertEquals(2, word.countOccurrences('L'));
		assertEquals(0, word.countOccurrences('l'));
	}
	// New
	@Test
	public void testCountOccurrencesDoesNotChangeWord() {
		Word word = new Word("banana");
		word.countOccurrences('a');
		assertEquals("banana", word.toString());
	}

	// Provided
	@Test
	public void testReplaceLastOccurrenceExceptionFirstArgument() {
		Word oneLetter = new Word("a");
     	assertThrows(IllegalArgumentException.class, () -> { oneLetter.replaceLastOccurrence(' ', 'l'); });
	}
	
	// Provided
	@Test
	public void testReplaceLastOccurrenceHello() {
		Word hello = new Word("hello");
		hello.replaceLastOccurrence('l', 's');
		assertEquals("helso", hello.toString());
	}
	// New
	@Test
	public void testReplaceLastOccurrenceNotFound() {
		Word word = new Word("hello");
		word.replaceLastOccurrence('z', 'a');
		assertEquals("hello", word.toString());
	}
	// New
	@Test
	public void testReplaceLastOccurrenceFirstCharacter() {
		Word word = new Word("apple");
		word.replaceLastOccurrence('a', 'o');
		assertEquals("opple", word.toString());
	}
	// New
	@Test
	public void testReplaceLastOccurrenceReplacementInvalid() {
		Word word = new Word("hello");
		assertThrows(IllegalArgumentException.class,
				() -> word.replaceLastOccurrence('l', '?'));
		assertEquals("hello", word.toString());
	}


	// Provided
	@Test
	public void testReverseHello() {
		Word hello = new Word("hello");
		assertEquals("olleh", hello.reverse().toString());
	}
	
	// Provided
	@Test
	public void testReverseEmpty() {
		Word empty = new Word("");
		assertEquals("", empty.reverse().toString());
	}
	// New
	@Test
	public void testReverseOneLetter() {
		Word word = new Word("a");
		assertEquals("a", word.reverse().toString());
	}
	// New
	@Test
	public void testReverseEvenLength() {
		Word word = new Word("abcd");
		assertEquals("dcba", word.reverse().toString());
	}
	// New
	@Test
	public void testReverseOddLength() {
		Word word = new Word("abc");
		assertEquals("cba", word.reverse().toString());
	}
	// New
	@Test
	public void testReverseMixedCase() {
		Word word = new Word("AbC");
		assertEquals("CbA", word.reverse().toString());
	}
}