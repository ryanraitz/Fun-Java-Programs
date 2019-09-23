//This program takes input from the user in degrees Fahrenheit and prints out the equivalent temperature in degrees Celcius

import java.util.*;
 
public class DegreeConverter
{
  
   public static void main(String[] args) 
   {
      int temp;
  
      
      Scanner kb=new Scanner(System.in);      
      System.out.println("Input Fahrenheit degree: ");
      temp=kb.nextInt();
   
      temp=((temp - 32)*5)/9;
   
      System.out.println("Celsius degree equivalent: "+ temp+" degrees Celcius");
   }
}