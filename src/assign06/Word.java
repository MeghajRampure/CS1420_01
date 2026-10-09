package assign06;

/**
 * This is the main word class with all methods
 *
 * @author Meghaj Rampure
 * @version Oct 8, 2026
 */

public class Word {
    private char[] letters;

    /**
     * Constructs a word from a string
     *
     * @param word the String used to create the word
     * @throws IllegalArgumentException if any character is not a letter
     */

    public Word(String word) {
        letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if (!((letters[i] >= 'a' && letters[i] <= 'z')
                    || (letters[i] >= 'A' && letters[i] <= 'Z'))) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Copies a character array to construct word
     *
     * @param word the array in use to create word
     * @throws IllegalArgumentException if any character is not a letter
     */

    public Word(char[] word) {
        letters = new char[word.length];

        for (int i = 0; i < word.length; i++) {
            if (!((word[i] >= 'a' && word[i] <= 'z')
                    || (word[i] >= 'A' && word[i] <= 'Z'))) {
                throw new IllegalArgumentException();
            }
            letters[i] = word[i];
        }
    }

    /**
     * Generates and returns a String object to represent this Word object
     * (driver method).
     *
     * @return a String object that represents this Word object
     */
    public String toString() {
        return toString(0);
    }

    /**
     * Generates and returns a String object to represent the letters of
     * this Word object from a given index to the last index (recursive method).
     *
     * @param startIndex - index at which to start
     * @return the letters of this Word from startIndex to the last index, as a String
     */
    private String toString(int startIndex) {
        // base case
        if (startIndex == letters.length)
            return "";
        // recursive case
        return letters[startIndex] + toString(startIndex + 1);
    }

    /**
     * Counts how many times a letter appears without changing the word
     *
     * @param letter the letter count
     * @return # of occurances
     * @throws IllegalArgumentException if character is not a letter
     */

    public int countOccurrences(char letter) {
        if (!((letter >= 'a' && letter <= 'z')
                || (letter >= 'A' && letter <= 'Z'))) {

            throw new IllegalArgumentException();
        }
        return countOccurrences(letter, 0);
    }

    /**
     * Recursively counts how many times a letter appears in a given index
     *
     * @param letter the letter to count
     * @param index  the index to check
     * @return the number of occurrences
     */

    private int countOccurrences(char letter, int index) {
        if (index == letters.length) {
            return 0;
        }

        if (letters[index] == letter) {
            return 1 + countOccurrences(letter, index + 1);
        }
        return countOccurrences(letter, index + 1);
    }

    /**
     * Replaces last occurrence of a letter with another letter
     *
     * @param letter      letter to replace
     * @param replacement new letter
     * @throws IllegalArgumentException if character given is not a letter
     */

    public void replaceLastOccurrence(char letter, char replacement) {
        if (!((letter >= 'a' && letter <= 'z')
                || (letter >= 'A' && letter <= 'Z'))
                || !((replacement >= 'a' && replacement <= 'z')
                || (replacement >= 'A' && replacement <= 'Z'))) {
            throw new IllegalArgumentException();
        }
        replaceLastOccurrence(letter, replacement, letters.length - 1);
    }

    /**
     * Searches backwards to replace last occurrence
     *
     * @param letter      letter to replace
     * @param replacement new letter
     * @param index       the current index of letter being checked
     */

    private void replaceLastOccurrence(char letter,
                                       char replacement, int index) {
        if (index < 0) {
            return;
        }
        if (letters[index] == letter) {
            letters[index] = replacement;
            return;
        }
        replaceLastOccurrence(letter, replacement, index - 1);

    }

    /**
     * Creates a new word in which the letters are in reverse order,
     * but it does not change the word
     * @return the new word in reverse order
     */

    public Word reverse() {
        char[] reversedWord = new char[letters.length];
        reverse(reversedWord, 0);
        return new Word(reversedWord);
    }

    /**
     * recursive method that copies letters into a new array in the reverse order
     *
     * @param reversedWord the array in which the reversed letters go into
     * @param index        the position in the array
     */
    private void reverse(char[] reversedWord, int index) {
        if (index == letters.length) {
            return;
        }
        reversedWord[index] = letters[letters.length - 1 - index];
        reverse(reversedWord, index + 1);

    }
}

















