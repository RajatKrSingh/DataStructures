package behavioural.strategy.runner;

import behavioural.strategy.checkout.*;
import behavioural.strategy.shipping.*;

public class Runner
{
    public static void main(String args[])
    {
        Checkout mycheckout = new Checkout(new StandardShippingStrategy());
        mycheckout.pay();
        mycheckout = new Checkout(new ExpressShippingStrategy());
        mycheckout.pay();
    }
}