package structural.decorator.data_source;

public interface DataSource
{
    public void write(String data);
    public String read(); 
}