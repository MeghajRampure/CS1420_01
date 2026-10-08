package assign06;

/**
 * This is the main word class with all methods
 *
 * @author Meghaj Rampure
 * @version Oct 8, 2026
 */

public class Word {
    private char[] letters;

    public Word(String word){
        if(word == null){
            throw new IllegalArgumentException("Word cannot be empty");
        }

        this.letters = new char[word.length()];
    }


    public Word(char[] word){

    }

}
