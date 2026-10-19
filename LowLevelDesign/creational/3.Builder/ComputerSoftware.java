package creational.builder.computer_software;

public abstract class ComputerSoftware
{
    public abstract void setOS();
    public abstract void setRam();
    public abstract void setGPU();
    public void installRequirements()
    {
        // Do nothing
    }
    public abstract void printConfig();
}