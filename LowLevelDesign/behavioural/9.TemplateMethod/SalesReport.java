package behavioural.template.report;

public class SalesReport extends ReportGenerator
{
    @Override
    public String fetchReportData()
    {
        System.out.println("Fetching Sales Report data");
        return "Data";
    }

    @Override
    public String formatData(String data)
    {
        System.out.println("Formatting Sales Report data");
        return "SALES_REPORT-> "+data;
    }
}