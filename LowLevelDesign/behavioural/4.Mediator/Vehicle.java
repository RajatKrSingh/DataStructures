package behavioural.mediator.vehicle;

public abstract class Vehicle
{
    public String vehicle_name, vehicle_type;

    public Vehicle(String vehicle_name, String vehicle_type)
    {
        this.vehicle_name = vehicle_name;
        this.vehicle_type = vehicle_type;
    }

    public abstract void land();
}