package creational.builder.computer_software;

public class ComputerSoftwareBuilder
{
    public void build(ComputerSoftware obj)
    {
        obj.setOS();
        if(obj instanceof ProgrammingComputerSoftware)
            obj.installRequirements();
        obj.setRam();
        obj.setGPU();
    }
}