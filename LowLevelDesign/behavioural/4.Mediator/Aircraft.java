package behavioural.mediator.vehicle;

import behavioural.mediator.mediator.*;

public class Aircraft extends Vehicle
{
    private final Mediator mediator;
    public Aircraft(String vehicle_name, Mediator mediator)
    {
        super(vehicle_name, "Aircraft");
        this.mediator = mediator;
    }
    @Override
    public void land()
    {
        mediator.requestLanding(this);
    }
}