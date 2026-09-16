package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellCheck {

    public static void main(String[] args) {
        File file = new File("src/lab04/words.txt");
        int count = countWords(file);
        System.out.println("Word count: " + count);

    }

    /**
     * Given a filename, this method returns a count of the number of
     * words in the file. If the file cannot be opened, -1 is returned.
     *
     * @param file the File object pointing to a text file
     * @return the count of words in the file or -1
     */
    public static int countWords(File file) {
        Scanner fileInput;
        try {
            fileInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            return -1;
        }

        int count = 0;
        while (fileInput.hasNext()) {
            count++;
            fileInput.next();
        }
        fileInput.close();
        return count;

    }

    public static String getClosestWord(String word, File file) {

        Scanner fileInput;
        try {
            fileInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            return "";
        }
        String current = "";
        while (fileInput.hasNext()) {
            current = fileInput.next();
            if (word.compareTo(current) <= 0) {
                break;
            }

        }
        fileInput.close();
        return current;

    }
}

