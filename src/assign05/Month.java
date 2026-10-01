package assign05;

public class Month {

    private int monthNumber;

    /**
     * Creates a Month object for January
     */

    public Month(){
        this.monthNumber =1;
    }

    /**
     * Creates month object with given month
     *
     * @param numberOfMonth
     */

    public Month(int numberOfMonth) {
        this.monthNumber = numberOfMonth;
    }

    /**
     * Returns month number
     *
     * @return 1-based month number
     */
    public int getMonthNumber() {
        return monthNumber;
    }

    /**
     * Returns last date of the given month
     *
     * @param isLeapYear See if year is leap year or not
     * @return last day of the month
     */

    public int lastDay(boolean isLeapYear) {
        if(monthNumber==2){
            if(isLeapYear){
                return 29;
            }
            return 31;
        }

        if (monthNumber == 4 || monthNumber == 6 ||
                monthNumber == 9 || monthNumber == 11){
            return 30;
        }
        return 31;
    }

    /**
     * Sees if a given day is valid or not for the given month
     *
     * @param day 1-based day of the month
     * @param isLeapYear Sees if the year is a leap year
     * @return true if day is valid and if not it is false
     */

    public boolean validDay(int day, boolean isLeapYear) {

        return day >= 1 && day <= lastDay(isLeapYear);
    }

    /**
     * Returns name of the month
     *
     * @return Name of the month
     */

    public String toString() {
        String [] monthNames = {"January", "February", "March",
                "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return monthNames[monthNumber - 1];
    }

    /**
     * Determines if this Month is the same as another object
     *
     * @param other   the reference object with which to compare.
     * @return True if both month objects have same month number
     */

    public boolean equals(Object other) {
        if (!(other instanceof Month)){
            return false;
        }
        Month otherMonth = (Month) other;
        return this.monthNumber == otherMonth.monthNumber;
    }


}
