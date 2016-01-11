package owe.model;

public class OwePayment
{
   private double paymentAmount;
   private String date;
   
   public OwePayment(String date, double paymentAmount)
   {
      this.date = date;
      this.paymentAmount = paymentAmount;
   }
   
   public String getDate()
   {
      return date;
   }
   
   public double getPaymentAmount()
   {
      return paymentAmount;
   }
   
   public String toString()
   {
      return "Date Paid : " + date + " : Amount Paid $" + paymentAmount;
   }
}
