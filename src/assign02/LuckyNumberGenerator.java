package assign02;

import java.util.Scanner;

/**
 * @Class: CS 1420
 * @Assignment: LuckyNumberGenerator
 * @author Meghaj_Rampure
 * @date September 10, 2026
 */

public class LuckyNumberGenerator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean keepGoing = true;

        while(keepGoing) {

            System.out.println("What is your name? ");
            String name = input.nextLine();

            if (name.equals("exit")) {
                System.out.println("Good luck!");
                keepGoing = false; }
            else {
                System.out.println( "In what month were you born? (Enter the month "
                        + "as a number; i.e., 1 for January.)");
                String monthInput = input.nextLine();

                if (monthInput.equals("exit")) {
                    System.out.println("Good luck!");
                    keepGoing = false;
                } else {
                    int month = Integer.parseInt(monthInput);

                    System.out.println("On what day of the month were you born?");
                    String dayInput = input.nextLine();

                    if (dayInput.equals("exit")) {
                        System.out.println("Good luck!");
                        keepGoing = false;


                    } else {
                        int day = Integer.parseInt(dayInput);
                        char firstCharacter = name.charAt(0);
                        int sum = 0;

                        if (firstCharacter == 'A' || firstCharacter == 'E'
                                || firstCharacter == 'I' || firstCharacter == 'O'
                                || firstCharacter == 'U' || firstCharacter == 'a'
                                || firstCharacter == 'e' || firstCharacter == 'i'
                                || firstCharacter == 'o' || firstCharacter == 'u') {

                            for (int i = 0; i < name.length(); i++) {
                                sum = sum + name.charAt(i);
                            }
                        } else if ((firstCharacter >= 'B' && firstCharacter <= 'L')
                                || (firstCharacter >= 'b' && firstCharacter <= 'l')) {
                            for (int i = 0; i < name.length(); i = i + 2) {
                                sum = sum + name.charAt(i);
                            }
                        } else {
                            for (int i = 1; i < name.length(); i = i + 2) {
                                sum = sum + name.charAt(i);
                            }
                        }

                        int luckyNumber = (sum % day) + month;
                        String monthName = "";
                        if (month == 1) {
                            monthName = "January";
                        }
                        else if (month == 2) {
                            monthName = "February";
                        }
                        else if (month == 3) {
                            monthName = "March";
                        }
                        else if (month == 4) {
                            monthName = "April";
                        }
                        else if (month == 5) {
                            monthName = "May";
                        }
                        else if (month == 6) {
                            monthName = "June";
                        }
                        else if (month == 7) {
                            monthName = "July";
                        }
                        else if (month == 8) {
                            monthName = "August";
                        }
                        else if (month == 9) {
                            monthName = "September";
                        }
                        else if (month == 10) {
                            monthName = "October";
                        }
                        else if (month == 11) {
                            monthName = "November";
                        }
                        else {
                            monthName = "December";
                        }
                        System.out.println("For " + name + " born on " + monthName +
                                " " + day + ", the lucky number is " + luckyNumber + ".");

                    }
                }
            }
        }

    }

}
