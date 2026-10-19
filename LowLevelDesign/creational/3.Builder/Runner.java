package creational.builder.runner;
import creational.builder.computer_software.*;

public class Runner
{
    public static void main(String args[])
    {
        ComputerSoftwareBuilder builder = new ComputerSoftwareBuilder();
        ComputerSoftware mysoftware;
        // Create gaming software
        System.out.println("CREATE GAMING SOFTWARE");
        mysoftware = new GamingComputerSoftware();
        builder.build(mysoftware);
        mysoftware.printConfig();

        // Create programming software
        System.out.println("CREATE PROGRAMMING SOFTWARE");
        mysoftware = new ProgrammingComputerSoftware();
        builder.build(mysoftware);
        mysoftware.printConfig();

    }
}