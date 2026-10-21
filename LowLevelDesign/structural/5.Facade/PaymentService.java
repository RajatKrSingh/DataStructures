package structural.facade.service;

public class PaymentService
{
    public boolean pay(double amount)
    {
        System.out.println("Payment of "+ amount +" successful");
        return true;
    }
}