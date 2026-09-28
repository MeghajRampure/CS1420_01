package assign04;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Assignment 04: MethodPractice
 *
 * @author Meghaj Rampure
 * @version Sep 22, 2026
 */

public class MethodPractice {

    /**
     * Converts centimeters to inches and rounds to nearest inch.
     *
     * @param centimeters amount of centimeters
     * @return The amount in inches
     */

    public static int centimetersToInches(double centimeters) {
        return ((int) (centimeters / 2.54));
    }

    /**
     * Encrypts the message by shifting each char
     * Character values are always in between 32 and 126
     *
     * @param message the message that is being encrypted
     * @param shift amount to shift message
     * @return the encrypted message
     */

    public static String shiftCipher(String message, int shift) {
        String encrypted = "";

        for (int i = 0; i < message.length(); i++) {
            int value = message.charAt(i);
            value += shift;

            while (value > 126) {
                value -= 95;
            }
            encrypted += (char) value;
        }
        return encrypted;
    }

    /**
     * Counts positive numbers from input
     *
     * @param input The input the scanner stores to check
     * @return The number of positive numbers
     */

    public static int countPositive(Scanner input){
        int count = 0;

        while(input.hasNext()){
            if(input.hasNextDouble()){
                double number = input.nextDouble();
                if (number > 0){
                    count++;
                }
            }
            else {
                input.next();
            }
        }
        return count;
    }

    /**
     * Calculates total of elements in an array
     *
     * @param numbers the array of int values
     * @param beginning starting index
     * @param ending ending index
     * @return total of elements in array
     */

    public static int totalInRange(int[] numbers, int beginning, int ending){
        if(beginning < 0 || ending > numbers.length || beginning >= ending){
            return 0;
        }
        int total = 0;

        for(int i = beginning; i < ending; i++){
            total += numbers[i];
        }
        return total;
    }

    /**
     * Creates an array of every other even number starting with 0
     *
     * @param length length of array
     * @return the array which contains even numbers
     */

    public static int[] generateEvenArray(int length){
        int [] numbers = new int[length];
        for(int i = 0; i < length; i++){
            numbers[i] = i * 2;
        }
        return numbers;
    }

    /**
     * Computes the sum of all even numbers from zero through the limit.
     *
     * @param limit the last even number included in the sum
     * @return the sum of the even numbers from zero through the limit
     */
    public static int sumEven(int limit) {
        int[] evenNumbers = generateEvenArray(limit / 2 + 1);

        return totalInRange(evenNumbers, 0, evenNumbers.length);
    }

    /**
     * Computes the integer base-two logarithm of a positive number.
     *
     * @param number the positive number whose logarithm is computed
     * @return the largest exponent for which the corresponding power of two
     *         is not greater than number
     */
    public static int logBaseTwo(int number) {
        int result = 0;

        while (number >= 2) {
            number /= 2;
            result ++;
        }
        return result;
    }

    /**
     * Runs all the 7 methods
     *
     * @param args
     */

    public static void main(String[] args) {
        // centimetersToInches checks

        // Provided
        System.out.println("Checking centimetersToInches(10.11). "
                + "Expecting a result of 3. The actual result is "
                + centimetersToInches(10.11) + ".");

        // Provided
        System.out.println("Checking centimetersToInches(20.5). "
                + "Expecting a result of 8. The actual result is "
                + centimetersToInches(20.5) + ".");

        // New
        System.out.println("Checking centimetersToInches(2.54). "
                + "Expecting a result of 1. The actual result is "
                + centimetersToInches(2.54) + ".");

        // New
        System.out.println("Checking centimetersToInches(25.4). "
                + "Expecting a result of 10. The actual result is "
                + centimetersToInches(25.4) + ".");

        // New
        System.out.println("Checking centimetersToInches(0). "
                + "Expecting a result of 0. The actual result is "
                + centimetersToInches(0) + ".");

        // shiftCipher checks

        // Provided
        System.out.println("Checking shiftCipher(\"hello\", 3). "
                + "Expecting a result of \"khoor\". The actual result is \""
                + shiftCipher("hello", 3) + "\".");

        // Provided
        System.out.println("Checking shiftCipher(\"(Zest!)\", 15). "
                + "Expecting a result of \"7it#$08\". The actual result is \""
                + shiftCipher("(Zest!)", 15) + "\".");

        // New
        System.out.println("Checking shiftCipher(\"hello\", 0). "
                + "Expecting a result of \"hello\". The actual result is \""
                + shiftCipher("hello", 0) + "\".");

        // New
        System.out.println("Checking shiftCipher(\"~\", 1). "
                + "Expecting a result of \" \". The actual result is \""
                + shiftCipher("~", 1) + "\".");

        // New
        System.out.println("Checking shiftCipher(\"abc\", 95). "
                + "Expecting a result of \"abc\". The actual result is \""
                + shiftCipher("abc", 95) + "\".");

        // countPositive checks

        // Provided
        System.out.println("Checking countPositive with "
                + "\"hello 0 10 2.2 string4 0.0\". "
                + "Expecting a result of 2. The actual result is "
                + countPositive(new Scanner(
                "hello 0 10 2.2 string4 0.0")) + ".");

        // New
        System.out.println("Checking countPositive with "
                + "\"0 -1 -2.5 0.0\". "
                + "Expecting a result of 0. The actual result is "
                + countPositive(new Scanner(
                "0 -1 -2.5 0.0")) + ".");

        // New
        System.out.println("Checking countPositive with "
                + "\"-5 0 1 2 3\". "
                + "Expecting a result of 3. The actual result is "
                + countPositive(new Scanner(
                "-5 0 1 2 3")) + ".");

        // New
        System.out.println("Checking countPositive with "
                + "\"hello -2 4.5 world 10\". "
                + "Expecting a result of 2. The actual result is "
                + countPositive(new Scanner(
                "hello -2 4.5 world 10")) + ".");

        // totalInRange checks

        // Provided
        System.out.println("Checking totalInRange on indices 2 through 5. "
                + "Expecting a result of 12. The actual result is "
                + totalInRange(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 5)
                + ".");

        // Provided
        System.out.println("Checking totalInRange with an invalid range "
                + "from index 5 through 2. "
                + "Expecting a result of 0. The actual result is "
                + totalInRange(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5, 2)
                + ".");

        // New
        System.out.println("Checking totalInRange on indices 0 through 3. "
                + "Expecting a result of 6. The actual result is "
                + totalInRange(
                new int[]{1, 2, 3, 4, 5}, 0, 3)
                + ".");

        // New
        System.out.println("Checking totalInRange on indices 1 through 1. "
                + "Expecting a result of 0 for an empty range. The actual result is "
                + totalInRange(
                new int[]{10, 20, 30}, 1, 1)
                + ".");

        // New
        System.out.println("Checking totalInRange with a beginning index of -1. "
                + "Expecting a result of 0 for an invalid range. The actual result is "
                + totalInRange(
                new int[]{5, 10, 15}, -1, 2)
                + ".");

        // generateEvenArray checks

        // Provided
        System.out.println("Checking generateEvenArray(5). "
                + "Expecting a result of [0, 2, 4, 6, 8]. "
                + "The actual result is "
                + Arrays.toString(generateEvenArray(5)) + ".");

        // New
        System.out.println("Checking generateEvenArray(0). "
                + "Expecting a result of []. "
                + "The actual result is "
                + Arrays.toString(generateEvenArray(0)) + ".");

        // New
        System.out.println("Checking generateEvenArray(1). "
                + "Expecting a result of [0]. "
                + "The actual result is "
                + Arrays.toString(generateEvenArray(1)) + ".");

        // New
        System.out.println("Checking generateEvenArray(2). "
                + "Expecting a result of [0, 2]. "
                + "The actual result is "
                + Arrays.toString(generateEvenArray(2)) + ".");

        // sumEven checks

        // Provided
        System.out.println("Checking sumEven(4). Expecting a result of 6. "
                + "The actual result is " + sumEven(4) + ".");

        // Provided
        System.out.println("Checking sumEven(100). Expecting a result of 2550. "
                + "The actual result is " + sumEven(100) + ".");

        // New
        System.out.println("Checking sumEven(0). Expecting a result of 0. "
                + "The actual result is " + sumEven(0) + ".");

        // New
        System.out.println("Checking sumEven(2). Expecting a result of 2. "
                + "The actual result is " + sumEven(2) + ".");

        // New
        System.out.println("Checking sumEven(10). Expecting a result of 30. "
                + "The actual result is " + sumEven(10) + ".");

        // logBaseTwo checks

        // Provided
        System.out.println("Checking logBaseTwo(512). "
                + "Expecting a result of 9. The actual result is "
                + logBaseTwo(512) + ".");

        // Provided
        System.out.println("Checking logBaseTwo(1). "
                + "Expecting a result of 0. The actual result is "
                + logBaseTwo(1) + ".");

        // Provided
        System.out.println("Checking logBaseTwo(12). "
                + "Expecting a result of 3. The actual result is "
                + logBaseTwo(12) + ".");

        // New
        System.out.println("Checking logBaseTwo(2). "
                + "Expecting a result of 1. The actual result is "
                + logBaseTwo(2) + ".");

        // New
        System.out.println("Checking logBaseTwo(7). "
                + "Expecting a result of 2. The actual result is "
                + logBaseTwo(7) + ".");

        // New
        System.out.println("Checking logBaseTwo(8). "
                + "Expecting a result of 3. The actual result is "
                + logBaseTwo(8) + ".");
    }
}