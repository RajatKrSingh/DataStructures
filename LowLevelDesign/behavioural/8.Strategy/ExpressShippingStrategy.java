package behavioural.strategy.shipping;

public class ExpressShippingStrategy implements ShippingStrategy
{
    @Override
    public void computeCost()
    {
        System.out.println("Cost for express shipping is Rs. 1000");
    }
}