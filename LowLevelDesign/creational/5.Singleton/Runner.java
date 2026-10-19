package creational.singleton.runner;

import creational.singleton.application_config.*;

public class Runner
{
    public static void main(String args[])
    {
        Thread thread_1 = new Thread(new ThreadVariant1()), thread_2 = new Thread(new ThreadVariant2());
        thread_2.start();
        thread_1.start();
    }

    static class ThreadVariant1 implements Runnable
    {
        @Override
        public void run()
        {
            ApplicationConfig config = ApplicationConfig.getInstance("FirstImplementation");
            System.out.println("Config fetched is: "+ config.config_value);
        }
    }
    static class ThreadVariant2 implements Runnable
    {
        @Override
        public void run()
        {
            ApplicationConfig config = ApplicationConfig.getInstance("SecondImplementation");
            System.out.println("Config fetched is: "+ config.config_value);
        }
    }
}