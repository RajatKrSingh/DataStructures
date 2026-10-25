package behavioural.mediator.vehicle;

import behavioural.mediator.mediator.*;

public class Helicopter extends Vehicle
{
    private final Mediator mediator;
    public Helicopter(String vehicle_name, Mediator mediator)
    {
        super(vehicle_name, "Helicopter");
        this.mediator = mediator;
    }

    @Override
    public void land()
    {
        mediator.requestLanding(this);
    }
}