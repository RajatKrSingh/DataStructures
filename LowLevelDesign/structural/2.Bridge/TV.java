package structural.bridge.device;

public class TV implements Device
{
    private boolean on = false;
    private int channel = 1, volume = 10;

    public int getVolume()
    {
        return this.volume;
    }

    public int getChannel()
    {
        return this.channel;
    }

    public void setVolume(int volume)
    {
         this.volume = volume;
    }

    public void setChannel(int channel)
    {
        this.channel = channel;
    }

    public void enable()
    {
        this.on = true;
    }

    public void disable()
    {
        this.on = false;
    }

    public void printSummary()
    {
        System.out.println("*".repeat(10)+" Current Device: TV "+ "*".repeat(10));
        System.out.println("Power Status"+ ((this.on==true)?"Enabled":"Disabled"));
        System.out.println("Volume: "+this.volume);
        System.out.println("Channel: "+ this.channel);
        System.out.println("*".repeat(35));
    }
}