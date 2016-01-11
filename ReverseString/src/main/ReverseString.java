package main;
import java.util.*;

public class ReverseString
{
   private static String s;
   private static Scanner sc = new Scanner(System.in);
   
   public static void main(String[] args)
   {
      System.out.print("Enter a string of characters: ");
      s = sc.nextLine();
      System.out.println("The reverse of " + s + " is " + reverse(s));
      
   }
   
   public static String reverse(String s)
   {
      char[] output = s.toCharArray();
      int length = s.length(), last = s.length() - 1;
      
      for (int i = 0 ;i < length/2 ; i++)
      {
         char c = output[i];
         output[i] = output[last - i];
         output[last - i] = c;
      } 
      
      return new String(output);
   }
}
