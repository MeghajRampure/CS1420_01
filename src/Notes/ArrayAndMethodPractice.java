package Notes;

/**
 *
 * @author Prof Parker and Meghaj Rampure CS 1420
 */

public class ArrayAndMethodPractice {
    public static void printArray(double[] array){
        System.out.print("[ ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i < array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
    public static void printArray(String[] array){
        System.out.print("[ ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i < array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
    public static void reverseWords(String[] words){
        for(int index = 0; index < words.length/2; index++){
            String temp = words[index];
            words[index] = words[words.length - 1 - index];
            words[words.length - 1 - index] = temp;

        }
    }
    public static void reverseWords(double[] words){
        for(int index = 0; index < words.length/2; index++){
            double temp = words[index];
            words[index] = words[words.length - 1 - index];
            words[words.length - 1 - index] = temp;

        }
    }

    public static void main(String[] args) {
        double[] temperatures = {98.6, 100.0, 56.7, 32.0 };
        printArray(temperatures);
        String[] words = {"Summer", "Fall", "Winter", "Spring", "Hi"};
        printArray(words);

        reverseWords(words);
        reverseWords(temperatures);

    }
}
