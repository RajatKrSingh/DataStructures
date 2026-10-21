package structural.bridge.remote;

import structural.bridge.device.*;

public class BasicRemote implements Remote
{
    private Device device;
    public BasicRemote(Device device)
    {
        this.device = device;
    }

    @Override
    public void increaseVolume()
    {
        int currentVolume = this.device.getVolume();
        this.device.setVolume(currentVolume+1);
    }

    @Override
    public void decreaseVolume()
    {
        int currentVolume = this.device.getVolume();
        this.device.setVolume(currentVolume-1);
    }

    @Override
    public void setChannel(int channel)
    {
        this.device.setChannel(channel);
    }

}