//Program that takes input in the form of a year and outputs whether or not that year is a leap year

import java.util.*;

public class LeapYearTest{

    public static void main(String[] args) 
    {

      Scanner kb=new Scanner(System.in);

      System.out.println("Please enter a year: ");

      int year=kb.nextInt();
        
      boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        if (isLeapYear)
        {
            System.out.println(year + " is a leap year.");
        } else
            System.out.println(year + " is not a leap year.");
    }

}