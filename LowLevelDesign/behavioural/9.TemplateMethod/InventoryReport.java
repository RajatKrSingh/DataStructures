package behavioural.template.report;

public class InventoryReport extends ReportGenerator
{
    @Override
    public String fetchReportData()
    {
        System.out.println("Fetching Inventory Report data");
        return "Data";
    }

    @Override
    public String formatData(String data)
    {
        System.out.println("Formatting Inventory Report data");
        return "INVENTORY_REPORT-> "+data;
    }
}