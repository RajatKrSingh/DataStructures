package behavioural.visitor.runner;

import behavioural.visitor.product.*;
import behavioural.visitor.tax.*;

public class Runner
{
    public static void main(String args[])
    {
        Product product1 = new Book(1000), product2 = new Electronics(1000);
        TaxComputer tax_visitor = new TaxComputer();
        product1.visit(tax_visitor);
        product2.visit(tax_visitor);
    }
}