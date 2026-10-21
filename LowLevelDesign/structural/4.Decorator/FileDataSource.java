package structural.decorator.data_source;

public class FileDataSource implements DataSource
{
    private String filename, filetext;
    public FileDataSource(String filename)
    {
        this.filename = filename;
        this.filetext = "";
    }

    @Override
    public String read()
    {
        System.out.println("Reading file "+ this.filename);
        System.out.println(this.filetext);
        return this.filetext;
    }
    
    @Override
    public void write(String data)
    {
        System.out.println("Writing file into "+ this.filename);
        this.filetext = data;
        System.out.println(this.filetext);
    }
}