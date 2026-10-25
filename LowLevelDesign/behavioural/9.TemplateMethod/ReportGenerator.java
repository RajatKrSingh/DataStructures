package behavioural.template.report;

public abstract class ReportGenerator
{
    public final void generateReport()
    {
        String data = fetchReportData();
        String formattedData = formatData(data);
        exportData(formattedData);
    }
    public void exportData(String data)
    {
        System.out.println("Exporting Data: "+data);
    }
    public abstract String fetchReportData();
    public abstract String formatData(String data);
}