package behavioural.mediator.runner;

import behavioural.mediator.mediator.*;
import behavioural.mediator.vehicle.*;

public class Runner
{
    public static void main(String args[])
    {
        Mediator mediator = new AirTrafficMediator();
        Vehicle vehicle1 = new Aircraft("Aircraft1", mediator), vehicle2 = new Helicopter("Helicopter1", mediator);
        vehicle2.land();
        vehicle1.land();
    }
}