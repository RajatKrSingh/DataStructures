package structural.decorator.decorator;

import structural.decorator.data_source.*;

public class CompressionDecorator extends DataSourceDecorator
{
    public CompressionDecorator(DataSource source)
    {
        super(source);
    }

    @Override
    public void write(String data)
    {
        System.out.println("Compressing data: "+data);
        super.write(compress(data));
    }

    @Override
    public String read()
    {
        String uncompressed_data = uncompress(super.read());
        System.out.println("Uncompressed Data: "+uncompressed_data);
        return uncompressed_data;
    }

    private String compress(String data)
    {
        return "COMPRESSED_DATA-->"+data;
    }

    private String uncompress(String data)
    {
        String result = data.replaceFirst("^" + "COMPRESSED_DATA-->", "");
        return result;
    }
}