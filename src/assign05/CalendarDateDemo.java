package assign05;

/**
 * This class contains a main method to demonstrate how to create and use 
 * CalendarDate objects, as well as a method to count the number of dates
 * in a given array that come before a given target date (to be added by 
 * students).
 * 
 * @author CS 1420 course staff and Meghaj Rampure
 * @version Sep 29 2026
 */
public class CalendarDateDemo {

	/**
	 * Counts the number of dates in an array coming before target array
	 *
	 * @param dates the array of dates to check
	 * @param target the date to compare against
	 * @return the number of dates that come before the target
	 */
	public static int countDatesBefore(CalendarDate[] dates, CalendarDate target) {
		int count = 0;

		for (CalendarDate date : dates) {
			if (date.comesBefore(target)) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		CalendarDate lastDayOfClass = new CalendarDate(12, 9, 2026);
		CalendarDate finalExamDate = new CalendarDate(12, 15, 2026);
 		
		System.out.println("The CS 1420 final exam is on " + finalExamDate + 
				", which is day " + finalExamDate.dayOfYear() + " of this year.");
		System.out.print("The last day of class is on " + lastDayOfClass + 
				", which is ");
		if(lastDayOfClass.comesBefore(finalExamDate))
			System.out.print("before");
		else if(lastDayOfClass.comesAfter(finalExamDate))
			System.out.print("after");
		else
			System.out.print("on the same day as");
		System.out.println(" the final exam.");
		
		finalExamDate.advanceOneDay();
		System.out.println("The next day of the exam period is " + finalExamDate + ".");
		
		CalendarDate[] classMeetings = new CalendarDate[28];
		classMeetings[0] = new CalendarDate(8, 31, 2026);
		classMeetings[1] = new CalendarDate(9, 14, 2026);
		classMeetings[2] = new CalendarDate(10, 26, 2026);
		classMeetings[3] = new CalendarDate(11, 16, 2026);
		classMeetings[4] = new CalendarDate(10, 7, 2026);
		classMeetings[5] = new CalendarDate(11, 25, 2026);
		classMeetings[6] = new CalendarDate(12, 7, 2026);
		classMeetings[7] = new CalendarDate(10, 19, 2026);
		classMeetings[8] = new CalendarDate(8, 24, 2026);
		classMeetings[9] = new CalendarDate(10, 5, 2026);
		classMeetings[10] = new CalendarDate(12, 9, 2026);
		classMeetings[11] = new CalendarDate(11, 9, 2026);
		classMeetings[12] = new CalendarDate(9, 21, 2026);
		classMeetings[13] = new CalendarDate(11, 30, 2026);
		classMeetings[14] = new CalendarDate(9, 30, 2026);
		classMeetings[15] = new CalendarDate(11, 2, 2026);
		classMeetings[16] = new CalendarDate(10, 21, 2026);
		classMeetings[17] = new CalendarDate(11, 23, 2026);
		classMeetings[18] = new CalendarDate(9, 2, 2026);
		classMeetings[19] = new CalendarDate(9, 28, 2026);
		classMeetings[20] = new CalendarDate(11, 4, 2026);
		classMeetings[21] = new CalendarDate(9, 16, 2026);
		classMeetings[22] = new CalendarDate(10, 28, 2026);
		classMeetings[23] = new CalendarDate(9, 23, 2026);
		classMeetings[24] = new CalendarDate(8, 26, 2026);
		classMeetings[25] = new CalendarDate(11, 11, 2026);
		classMeetings[26] = new CalendarDate(9, 9, 2026);
		classMeetings[27] = new CalendarDate(12, 2, 2026);
	
		System.out.println("There are " + countDatesBefore(classMeetings, new CalendarDate(10, 21, 2026)) +
				" class meetings before the midterm exam.");
	}
}