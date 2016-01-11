package owe.model;

public class OweLoan
{

   private double amount;
   private String date;

   public OweLoan(String date, double amount)
   {
      this.date = date;
      this.amount = amount;
   }
   
   public double getAmount()
   {
      return amount;
   }

   public String toString()
   {
      return "Date Borrowed : " + date + " : Amount Borrowed  $" + amount;
   }
}
