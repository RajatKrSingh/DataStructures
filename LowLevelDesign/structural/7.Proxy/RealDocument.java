package structural.proxy.document;

public class RealDocument implements Document
{
    private String filename;
    public RealDocument(String filename)
    {
        this.filename = filename;
        loadfromdisk(filename);
    }

    public void loadfromdisk(String filename)
    {
        System.out.println("Loading from disk "+ filename);
    }

    @Override
    public void read()
    {
        System.out.println("Reading file "+ this.filename);
    }
}