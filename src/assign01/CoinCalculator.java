package assign01;

public class CoinCalculator {
    /**
     * @Class: CS 1420
     * @Assignment: Coin_Calculator
     * @author Meghaj_Rampure
     * @date September 3, 2026
     */

    public static void main(String[] args) {

        int uid = 1557812; // your UID is entered here

        int dollars = uid / 100;
        int remainingPennies = uid % 100;

        int quarters = remainingPennies / 25;
        remainingPennies = remainingPennies % 25;

        int dimes = remainingPennies / 10;
        remainingPennies = remainingPennies % 10;

        int nickels = remainingPennies / 5;
        int pennies = remainingPennies % 5;

        System.out.println(uid + " pennies is equivalent to "
                + dollars + " dollar(s), "
                + quarters + " quarter(s), "
                + dimes + " dime(s), "
                + nickels + " nickel(s), and "
                + pennies + " penny(ies).");
    }

}
