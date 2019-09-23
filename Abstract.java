//Program to highlight the use of abstract classes and methods using the simple "Hello World!" method

abstract class Abstract
{  
  abstract void print();  
}  
class Derived extends Abstract
{  
   void print()
   {
      System.out.println("Hello World!");
   }
  
   public static void main(String args[])
   {  
      Abstract obj = new Derived();  
      obj.print();  
   }  
} 