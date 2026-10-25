package behavioural.visitor.product;

import behavioural.visitor.tax.*;

public class Electronics implements Product
{
    private double price;
    public Electronics(double price)
    {
        this.price = price;
    }

    @Override
    public double getPrice()
    {
        return this.price;
    }

    @Override
    public void visit(TaxComputer visitor)
    {
        visitor.compute_tax(this);
    }
}