package assign07;

/**
 * Provides recursive Binary and sequential search methods
 *
 * @author Meghaj Rampure
 * @version 10/29/26
 */

import java.util.Arrays;


public class CandidateSearch {
    private static int callCount;

    /**
     * Returns the number of recursive calls
     *
     * @return the number of call counts
     */

    public static int  getCallCount() {
        return callCount;
    }

    /**
     * Searches for candidate using sequential search
     *
     * @param array the array of candidates
     * @param target the chosen candidate
     * @return Matching candidate of the array
     */

    public static Candidate sequentialSearch(Candidate [] array, Candidate target) {
        callCount=0;
        return sequentialSearchRecursive(array, target, 0);
    }

    /**
     * Recursively searches Candidate array
     *
     * @param array the array to be searched
     * @param target Candidate to find
     * @param index the index to check
     * @return the matching candidate
     */

    private static Candidate sequentialSearchRecursive(Candidate [] array, Candidate target, int index) {
        callCount++;
        if (index == array.length) {
            return null;
        }

        if (array[index].equals(target)) {
            return array[index];
        }

        return sequentialSearchRecursive(array, target, index + 1);
    }

    /**
     * Sorts array and uses binary search
     *
     * @param array the array of candidates
     * @param target the candidate to find
     * @return the correct candidate from the array
     */

    public static Candidate binarySearch(Candidate [] array, Candidate target) {
        callCount = 0;
        Arrays.sort(array);
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    /**
     * Recursively searches for candidate using binary search
     *
     * @param array array of candidates
     * @param target the candidate to find
     * @param low lower index of search page
     * @param high higher index of search page
     * @return the matching candidate
     */

    public static Candidate binarySearchRecursive(Candidate [] array, Candidate target, int low, int high) {
        callCount++;

        if(low > high) {
            return null;
        }

        int mid = (low + high)/2;

        if (array[mid].compareTo(target) == 0) {
            return array[mid];
        }

        if(array[mid].compareTo(target) < 0) {
            return binarySearchRecursive(array, target, mid +1, high);
        }

        return binarySearchRecursive(array, target, low, mid - 1);

    }

}
