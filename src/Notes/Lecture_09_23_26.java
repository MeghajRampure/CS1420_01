package notes;

import Notes.Fraction;

/**
 * This class represents a fraction; e.g., 1/2.
 *
 * @author Prof. Parker and CS 1420 students
 * @version September 21, 2026
 */
public class Lecture_09_23_26 {
    private int numerator;
    private int denominator;

    /**
     * This constructor builds a "default" Fraction object 0/1.
     */
    public void Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * This constructor builds a Fraction object, given the data passed.
     *
     * @param numerator - value for initializing the numerator
     * @param denominator - value for initializing the denominator
     */
    public void Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Getter method for accessing the numerator of this Fraction object.
     *
     * @return numerator of this fraction
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Getter method for accessing the denominator of this Fraction object.
     *
     * @return denominator of this fraction
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * This method calculates the decimal-point equivalent of this Fraction object.
     *
     * @return decimal-point equivalent of this fraction
     */
    public double toDouble() {
        return this.numerator / (double)this.denominator;
    }

    /**
     * This method generates a textual representation of this Fraction object.
     *
     * @return textual representation of this Fraction object
     */
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * This method prints values of the numerator and denominator of this Fraction
     * object and the Fraction object passed as a parameter.
     * (The intent of this method is to show an example of using the "this" keyword.)
     *
     * @param other - another Fraction
     */
    public void printTwoFractions(Fraction other) {
        System.out.println("This object’s variables: " + this.numerator + " " + this.denominator);
        System.out.println("Other object’s variables: " + other.numerator + " " + other.denominator);
    }
}