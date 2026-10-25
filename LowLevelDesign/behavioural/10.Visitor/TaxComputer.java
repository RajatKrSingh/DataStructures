package behavioural.visitor.tax;

import behavioural.visitor.product.*;

public class TaxComputer
{
    public void compute_tax(Book book)
    {
        System.out.println("Total tax computed on book is "+ (book.getPrice()*0.05));
    }

    public void compute_tax(Electronics electronics)
    {
        System.out.println("Total tax computed on electronics is "+(electronics.getPrice()*.15));
    }
}