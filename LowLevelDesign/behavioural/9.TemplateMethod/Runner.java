package behavioural.template.runner;

import behavioural.template.report.*;

public class Runner
{
    public static void main(String args[])
    {
        System.out.println("GENERATING SALES REPORT");
        ReportGenerator reportgenerator = new SalesReport();
        reportgenerator.generateReport();

        System.out.println("GENERATING INVENTORY REPORT");
        reportgenerator = new InventoryReport();
        reportgenerator.generateReport();
    }
}