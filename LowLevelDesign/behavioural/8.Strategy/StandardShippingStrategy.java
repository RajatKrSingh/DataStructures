package behavioural.strategy.shipping;

public class StandardShippingStrategy implements ShippingStrategy
{
    @Override
    public void computeCost()
    {
        System.out.println("Cost for standard shipping is Rs. 100");
    }
}