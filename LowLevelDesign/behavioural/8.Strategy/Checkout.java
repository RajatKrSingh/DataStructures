package behavioural.strategy.checkout;

import behavioural.strategy.shipping.*;

public class Checkout
{
    private ShippingStrategy strategy;
    public Checkout(ShippingStrategy strategy)
    {
        this.strategy = strategy;
    }
    public void pay()
    {
        this.strategy.computeCost();
    }
}