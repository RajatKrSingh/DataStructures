package creational.builder.computer_software;

import java.util.*;

public class ProgrammingComputerSoftware extends ComputerSoftware
{
    private String os, gpu;
    private int ram;
    List<String> requirements = new ArrayList<>();
    public void setOS()
    {
        os = "Linux";
    }
    public void setGPU()
    {
        gpu = "Nvidia 256MB";
    }
    public void setRam()
    {
        ram = 4;
    }
    public void installRequirements()
    {
        requirements.add("Python");
        requirements.add("Numpy");
    }
    public void printConfig()
    {
        System.out.println("*".repeat(20));
        System.out.println("Operating System "+os);
        System.out.println("RAM "+ ram);
        System.out.println("GPU "+ gpu);
        System.out.println("Requirements installed: "+requirements);
        System.out.println("*".repeat(20));
    }
}