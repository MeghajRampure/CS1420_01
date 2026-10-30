package assign07;

import java.util.Arrays;

public class CandidateSearch {
    private static int callCount;

    public static int  getCallCount() {
        return callCount;
    }

    public static Candidate sequentialSearch(Candidate [] array, Candidate target) {
        callCount=0;
        return sequentialSearchRecursive(array, target, 0);
    }

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

    public static Candidate binarySearch(Candidate [] array, Candidate target) {
        callCount = 0;
        Arrays.sort(array);
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

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
