package assign03; /**
 * @Class: CS 1420
 * @Assignment: Grade Predictor
 * @author Meghaj_Rampure
 * @date September 10, 2026
 */

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GradePredictor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner file = null;    // Declares Scanner and keeps the value at null --> holds no values
        boolean fileOpened = false;

        while(fileOpened==false){
            System.out.println("Please enter the file name to read:");
            String fileName = input.nextLine();

            try {
                file = new Scanner(new File(fileName));
                fileOpened = true;
            } catch (IOException e) {
                System.out.println("There was an error reading the file name.");
            }
        }
        // Now you have to read the 4 scores from file.
        double midterm = file.nextDouble();
        double finalExam = file.nextDouble();
        double labAverage = file.nextDouble();
        double quizAverage = file.nextDouble();

        //Now read the # of assignments
        int assignmentCount = file.nextInt();

        // Now create the assignment array
        int[] assignmentScores = new int[assignmentCount];

        //Total assignmentScores
        int assignmentSum  = 0;

        for (int index = 0; index < assignmentCount ; index++) {
            assignmentScores[index] = file.nextInt();

        }
        //average assignment score
        for (int index = 0; index < assignmentScores.length; index++) {
            assignmentSum =
                    assignmentSum + assignmentScores[index];
        }
        double assignmentAverage =
                (double) assignmentSum / assignmentScores.length;

        System.out.printf(
                "The average assignment score is %.2f.%n",
                assignmentAverage);

        Arrays.sort(assignmentScores);

        int medianAssignmentScore =
                assignmentScores[assignmentScores.length / 2];
        System.out.println(
                "The median assignment score is "
                        + medianAssignmentScore + ".");

        int zeroCount = 0;

        for (int index = 0; index < assignmentScores.length; index++) {
            if (assignmentScores[index] == 0) {
                zeroCount = zeroCount + 1;
            }
        }

        System.out.println("The number of 0 assignment scores is " + zeroCount + ".");

        int lowestAssignmentScore = assignmentScores[0];

        int highestAssignmentScore = assignmentScores[assignmentScores.length - 1];

        System.out.println(
                "The highest assignment score is "
                        + highestAssignmentScore + ".");

        System.out.println(
                "The lowest assignment score is "
                        + lowestAssignmentScore + ".");
        double knownContribution =
                0.20 * assignmentAverage
                        + 0.15 * finalExam
                        + 0.10 * midterm
                        + 0.10 * labAverage
                        + 0.05 * quizAverage;

        double[] targetScores = {
                70.0, 73.0, 77.0, 80.0,
                83.0, 87.0, 90.0, 93.0
        };

        String[] targetGrades = {
                "C-", "C", "C+", "B-",
                "B", "B+", "A-", "A"
        };

        for (int index = 0; index < targetScores.length; index++) {
            double requiredTestAverage =
                    (targetScores[index] - knownContribution) / 0.40;

            if (requiredTestAverage < 0.0) {
                requiredTestAverage = 0.0;
            }

            if (requiredTestAverage > 100.0) {
                System.out.println(
                        "It is not possible to achieve "
                                + targetGrades[index]
                                + " with these scores.");
            } else {
                System.out.printf(
                        "A test average of %.2f is needed to achieve %s.%n",
                        requiredTestAverage,
                        targetGrades[index]);
            }
        }
        file.close();
        input.close();
        System.out.println("hi");


    }


}
