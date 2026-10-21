package structural.decorator.decorator;

import structural.decorator.data_source.*;

public abstract class DataSourceDecorator implements DataSource
{
    private DataSource mywrapper;
    public DataSourceDecorator(DataSource newdecorator)
    {
        this.mywrapper = newdecorator;
    }

    @Override
    public String read()
    {
        return this.mywrapper.read();
    }

    @Override
    public void write(String data)
    {
        this.mywrapper.write(data);
    }
}