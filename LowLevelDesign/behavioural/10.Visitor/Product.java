package behavioural.visitor.product;

import behavioural.visitor.tax.*;

public interface Product
{
    public double getPrice();
    public void visit(TaxComputer visitor);
}