//This program takes two inputs from the user in the form of integers and outputs the greatest common denominator between the two numbers

import java.util.*;

public class GCD
{


public static void main(String[] args)
{
Scanner kb=new Scanner(System.in);
System.out.println("Type in two numbers: ");
int one=kb.nextInt();
int two=kb.nextInt();

  if (one == 0)
  {
  System.out.println("The GCD is: "+ two);
  }
    
  while (two != 0) 
  {
    if (one > two)
    {
       one = one - two;
    }
    else
    {
     two = two - one;
    }
   }
    System.out.println("The GCD is: "+ one);
  }

}