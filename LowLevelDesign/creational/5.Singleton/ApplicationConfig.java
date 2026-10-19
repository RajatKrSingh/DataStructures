package creational.singleton.application_config;

public class ApplicationConfig
{
    public String config_value;
    private static volatile ApplicationConfig instance;

    private ApplicationConfig(String value)
    {
        this.config_value = value;
    }

    public static ApplicationConfig getInstance(String config_value)
    {
        ApplicationConfig result = instance;
        if(result != null)
            return result;
        synchronized(ApplicationConfig.class)
        {
            if(instance==null)
                instance = new ApplicationConfig(config_value);
            return instance;
        }
    }
}