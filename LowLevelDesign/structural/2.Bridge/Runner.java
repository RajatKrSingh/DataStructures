package structural.bridge.runner;

import structural.bridge.device.*;
import structural.bridge.remote.*;

public class Runner
{
    public static void main(String args[])
    {
        Device mydevice = new Radio();
        System.out.println("Working with Radio");
        BasicRemote myremote = new BasicRemote(mydevice);
        myremote.increaseVolume();
        myremote.setChannel(23);
        mydevice.printSummary();

        System.out.println("Working with TV");
        mydevice = new TV();
        myremote = new BasicRemote(mydevice);
        myremote.decreaseVolume();
        myremote.setChannel(30);
        mydevice.printSummary();
    }
}