package structural.decorator.runner;

import structural.decorator.data_source.*;
import structural.decorator.decorator.*;

public class Runner
{
    public static void main(String args[])
    {
        String password = "My Password is Hola";
        DataSourceDecorator encoded = new CompressionDecorator(
                                         new EncryptionDecorator(
                                             new FileDataSource("dummyfile.txt")));
        encoded.write(password);
        System.out.println("- Decoded --------------");
        System.out.println(encoded.read());
    }
}