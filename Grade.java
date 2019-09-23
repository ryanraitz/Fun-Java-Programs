//Program that takes input in the form of a numerical grade and outputs the corresponding letter grade

import java.util.*;

public class Grade
{

   public static void main(String[] args)
   {
      int grade;
   
      Scanner kb=new Scanner(System.in);
   
      System.out.println("Please enter your numerical grade: ");
   
      grade=kb.nextInt();
   
      if(grade>=90 && grade<=100)
      {
         System.out.println("You made an A");
      }
      else if(grade>=80)
      { 
         System.out.println("You made a B");
      }
      else if(grade>=72)
      {
         System.out.println("You made a C");
      }
      else if(grade>=70)
      {
         System.out.println("You made a D");
      }
      else if(grade<70)
      {
         System.out.println("You made an F");
      }
      else
      {
         System.out.println("Invalid score");
      }
   }
}