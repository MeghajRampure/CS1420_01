package assign05;


/**
 * Shows a date on the calendar
 *
 * @author Meghaj Rampure
 * @version Oct 1 2026
 */

public class CalendarDate {

    private Month month;
    private int day;
    private int year;

    /**
     * Creates calendar day Jan 1, 1000
     */
    public CalendarDate() {

        this.month = new Month();
        this.day = 1;
        this.year = 1000;

    }

    /**
     * Creates CalendarDate with month day and year
     *
     * @param monthNumber 1-based month number
     * @param day 1-based day of month
     * @param year 4 digit year
     */

    public CalendarDate(int monthNumber, int day, int year){
        this.month = new Month(monthNumber);
        this.day = day;
        this.year = year;
    }

    /**
     * Returns month object
     *
     * @return Month Object
     */

    public Month getMonth() {
        return month;
    }

    /**
     * Returns day of the month
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the year
     *
     * @return the year
     */

    public int getYear() {
        return year;
    }


    /**
     * Sees whether or not this date comes before another date
     *
     * @param other the date to compare with
     * @return true if this date comes before another date
     */

    public boolean comesBefore(CalendarDate other) {
        if(this.year < other.year){
            return true;
        }
        if (this.year > other.year){
            return false;
        }
        if(this.month.getMonthNumber() < other.month.getMonthNumber()){
            return true;
        }
        if(this.month.getMonthNumber() > other.month.getMonthNumber()) {
            return false;
        }

        return this.day < other.day;
    }

    /**
     * Sees if this date comes after another date.
     *
     * @param other the date to compare with
     * @return true if this date comes after the other date
     */
    public boolean comesAfter(CalendarDate other) {
        return !this.comesBefore(other) && !this.equals(other);
    }

    /**
     * Advances this date by one day.
     */
    public void advanceOneDay() {
        if (day < month.lastDay(isLeapYear())) {
            day++;
        }
        else {
            day = 1;

            if (month.getMonthNumber() < 12) {
                month = new Month(month.getMonthNumber() + 1);
            }
            else {
                month = new Month(1);
                year++;
            }
        }
    }

    /**
     * Returns the position of this date within its year.
     *
     * @return 1-based day of the year
     */
    public int dayOfYear() {
        int totalDays = day;

        for (int monthNumber = 1;
             monthNumber < month.getMonthNumber();
             monthNumber++) {
            Month previousMonth = new Month(monthNumber);
            totalDays += previousMonth.lastDay(isLeapYear());
        }

        return totalDays;
    }

    /**
     * Sees whether this date's year is a leap year.
     *
     * @return true if the year is a leap year and false otherwise
     */
    public boolean isLeapYear() {
        return year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Returns the text of this date.
     *
     * @return the date as a String
     */
    public String toString() {
        return month + " " + day + ", " + year;
    }

    /**
     * Sees whether this date is equal to another object.
     *
     * @param other the object to compare with this date
     * @return true if both objects represent the same date
     */
    public boolean equals(Object other) {
        if (!(other instanceof CalendarDate))
            return false;

        CalendarDate otherDate = (CalendarDate) other;

        return this.month.equals(otherDate.month) &&
                this.day == otherDate.day &&
                this.year == otherDate.year;
    }
}

