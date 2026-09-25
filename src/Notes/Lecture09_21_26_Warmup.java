package Notes;

import java.util.Arrays;


/**
 * @author Meghaj Rampure
 * @version Sep 21 2026
 */

public class Lecture09_21_26_Warmup {
    public static void printArray(int array[], int multiplier) {
        for(int i = 0; i < array.length; i++){
            array[i] *= multiplier;
        }

    }

    public static void main(String[] args) {
        int[] values = {20,0,3,-100,6,7};
        System.out.println("Before multiplication: " + Arrays.toString(values));
        System.out.println("After multiplication: " + Arrays.toString(values));
    }


    }
