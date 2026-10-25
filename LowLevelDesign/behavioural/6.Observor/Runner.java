package behavioural.observor.runner;

import behavioural.observor.application.Application;

public class Runner
{
    public static void main(String args[])
    {
        Application myapplication = new Application();
        myapplication.executeEventA();
        System.out.println("Removing subscriber");
        myapplication.removeSubscriber();
        myapplication.executeEventA();
    }
}