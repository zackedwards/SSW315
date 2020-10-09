/* Date.java */
package Homework2;
import java.io.*;

class Date {
	private int dateMonth;
	private int dateDay;
	private int dateYear;

  /* Put your private data fields here. */

	
  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	  if (isValidDate(month,day,year) == true) {
		  dateMonth = month;
		  dateDay = day;
		  dateYear = year;
	  }
	  else {
		  System.out.println("This is not a valid date");
		  System.exit(0);
	  }

  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
	  String[] str = s.split("/");
	  int month = Integer.parseInt(str[0]);
	  int day = Integer.parseInt(str[1]);
	  int year = Integer.parseInt(str[2]);
	  if (isValidDate(month,day,year) == true) {
		  dateMonth = month;
		  dateDay = day;
		  dateYear = year;
	  }
	  else {
		  System.out.println("This is not a valid date");
		  System.exit(0);
	  }

  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
	  return (year%400 == 0 || (year%4 == 0 && year%100 != 0));    // replace this line with your solution
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
	  int thirty = 30;
	  int thirty1 = 31;
	  int twenty9=29;
	  int twenty8 = 28;
	  
	  if (month == 1) {
		  return thirty1;
	  }
	  else if (month == 2) {
		  if(isLeapYear(year) == true) {
			  return twenty9;
		  }
		  else if (isLeapYear(year) == false)
			  return twenty8;
	  }
	  else if (month == 3) {
		  return thirty1;
	  }
	  else if (month == 4) {
		  return thirty;
	  }
	  else if (month == 5) {
		  return thirty1;
	  }
	  else if (month == 6) {
		  return thirty;
	  }
	  else if (month == 7) {
		  return thirty1;
	  }
	  else if (month == 8) {
		  return thirty1;
	  }
	  else if (month == 9) {
		  return thirty;
	  }
	  else if (month == 10) {
		  return thirty1;
	  }
	  else if (month == 11) {
		  return thirty;
	  }
	  else if (month == 12) {
		  return thirty1;
	  }
	   // replace this line with your solution
	  return 0;
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    if (year >= 1) {
    	if(1 <= month && month <= 12) {
    		if (day <= daysInMonth(month, year) && day != 0 && day > 0) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;// replace this line with your solution
    	}
    }
    else {
    	return false;
    }
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
	  return dateMonth + "/" + dateDay + "/" + dateYear;                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
	  if(this.dateYear < d.dateYear) {
		  return true;
	  }
	  else if(this.dateYear == d.dateYear) {
		  if(this.dateMonth < d.dateMonth) {
			  return true;
		  }
		  else if(this.dateMonth == d.dateMonth) {
			  if(this.dateDay < d.dateDay) {
				  return true;
			  }
			  else if(this.dateDay >= d.dateDay) {
				  return false;
			  }
		  }
	  }
    return false;                        // replace this line with your solution
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
	  if(this.dateYear > d.dateYear) {
		  return true;
	  }
	  else if(this.dateYear == d.dateYear) {
		  if(this.dateMonth > d.dateMonth) {
			  return true;
		  }
		  else if(this.dateMonth == d.dateMonth) {
			  if(this.dateDay > d.dateDay) {
				  return true;
			  }
			  else if(this.dateDay <= d.dateDay) {
				  return false;
			  }
		  }
	  }
    return false;                        // replace this line with your solution
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
	  int dayTotal = 0;
	  for (int i = 1; i < this.dateMonth; i++) {
		  dayTotal = dayTotal + daysInMonth(i, this.dateYear);
	  }
      dayTotal = dayTotal + this.dateDay;                         // replace this line with your solution
      return dayTotal;
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
	  int positive = 0;
	  int negative = 0;
	  if(this.isBefore(d)) {
		  for(int i = d.dateYear; i>this.dateYear+1; i--) {
			  if(isLeapYear(i)) {
				  negative = negative - 366;
			  }
			  else {
				  negative = negative - 365;
			  }
		  }
		  if(isLeapYear(this.dateYear)) {
			  negative = negative -  (366 - this.dayInYear()) - d.dayInYear();
		  }
		  else {
			  negative = negative -  (365 - this.dayInYear()) - d.dayInYear();
		  }
		  return negative;
	  }
	  else if(this.isAfter(d)) {
		  for(int i = this.dateYear; i>d.dateYear+1; i--) {
			  if(isLeapYear(i)) {
				  positive = positive + 366;
			  }
			  else {
				  positive = positive + 365;
			  }
		  }
		  if(isLeapYear(d.dateYear)) {
			  positive = positive + (366 - d.dayInYear()) + this.dayInYear();
		  }
		  else {
			  positive = positive + (365 - d.dayInYear()) + this.dayInYear();
		  }
		  return positive;
	  }
	  else {
		  return 0;
	  }
	  
                               // replace this line with your solution
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
