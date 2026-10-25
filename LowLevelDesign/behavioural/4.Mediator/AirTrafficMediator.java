package behavioural.mediator.mediator;

import behavioural.mediator.vehicle.*;

public class AirTrafficMediator implements Mediator
{
    @Override
    public void requestLanding(Vehicle vehicle)
    {
        System.out.println("Granting landing permission to vehicle type "+ vehicle.vehicle_type+ " named "+ vehicle.vehicle_type);
    }
}