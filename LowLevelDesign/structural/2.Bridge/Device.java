package structural.bridge.device;

public interface Device
{
    public int getVolume();
    public void setVolume(int volume);
    public void enable();
    public void disable();
    public void setChannel(int channel);
    public void printSummary();
}