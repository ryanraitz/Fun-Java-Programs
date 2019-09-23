//This program takes 3 inputs from the user: initial deposit amount, interest rate percentage, and number of years and outputs
//the amount of money you will compound each year for the next 5 years

import java.util.*;
import java.text.NumberFormat;

public class Interest
{

public static void main(String[] args)
{

double amount;
double rate;
double years;

Scanner kb=new Scanner(System.in);

System.out.println("Enter the initial deposit amount: ");
amount=kb.nextDouble();

System.out.println("Enter the interest rate (%): ");
rate=kb.nextDouble();

System.out.println("Enter the number of years: ");
years=kb.nextDouble();


System.out.println("Initial: "+amount);
double total=amount;
for(int i=1; i<=years; i++)
 {
  total+=total*rate;

  System.out.println("End of year "+i+": $"+NumberFormat.getNumberInstance(Locale.US).format(total));
 }
}
}



