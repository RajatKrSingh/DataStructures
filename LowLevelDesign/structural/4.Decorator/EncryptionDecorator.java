package structural.decorator.decorator;

import structural.decorator.data_source.*;

public class EncryptionDecorator extends DataSourceDecorator
{
    public EncryptionDecorator(DataSource source)
    {
        super(source);
    }

    @Override
    public void write(String data)
    {
        System.out.println("Encrypting data: "+data);
        super.write(encrypt(data));
    }

    @Override
    public String read()
    {
        String decrypted_data = decrypt(super.read());
        System.out.println("Decrypted Data: "+decrypted_data);
        return decrypted_data;
    }

    private String encrypt(String data)
    {
        return "ENCRYPED_DATA-->"+data;
    }

    private String decrypt(String data)
    {
        String result = data.replaceFirst("^" + "ENCRYPED_DATA-->", "");
        return result;
    }
}