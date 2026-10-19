package creational.builder.computer_software;

public class GamingComputerSoftware extends ComputerSoftware
{
    private String os, gpu;
    private int ram;
    public void setOS()
    {
        os = "Windows";
    }
    public void setGPU()
    {
        gpu = "Nvidia 4GB";
    }
    public void setRam()
    {
        ram = 16;
    }
    public void printConfig()
    {
        System.out.println("*".repeat(20));
        System.out.println("Operating System "+os);
        System.out.println("RAM "+ ram);
        System.out.println("GPU "+ gpu);
        System.out.println("*".repeat(20));
    }
}