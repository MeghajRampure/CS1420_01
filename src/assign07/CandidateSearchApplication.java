package assign07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CandidateSearchApplication {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Usage: CandidateSearchApplication <filepath> <name> <age>");
            return;
        }
        File file = new File(args[0]);
        Scanner fileScanner;

        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
            return;

        }


        int numberOfCandidates = fileScanner.nextInt();
        Candidate[] candidates = new Candidate[numberOfCandidates];

        for (int i = 0; i < numberOfCandidates; i++) {
            String name = fileScanner.next();
            int age = fileScanner.nextInt();
            int rating = fileScanner.nextInt();

            candidates[i] = new Candidate(name, age, rating);
        }

        fileScanner.close();

        String targetName = args[1];
        int targetAge = Integer.parseInt(args[2]);

        Candidate target = new Candidate(targetName, targetAge);

        Candidate result = CandidateSearch.binarySearch(candidates, target);

        if(result != null) {
            System.out.println(result + "has rating " + result.getRating());
        } else {
            System.out.println(target + " was not found.");
        }
    }
}

