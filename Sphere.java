//This program takes input from the user in the form of the radius of a sphere and outputs the volume of the sphere

import java.util.*;

public class Sphere
{

 public static void main(String[] args)
   {
     Scanner s=new Scanner(System.in);
     System.out.println("Input the radius of the sphere: ");
     double rad=s.nextDouble();
     double vol= (4.0/3) * Math.PI * Math.pow(rad, 3);
     
     System.out.println("Volume of the sphere: "+vol;
    }
  }
