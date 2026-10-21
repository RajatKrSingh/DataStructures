package structural.facade.runner;

import structural.facade.facade.*;

public class Runner
{
    public static void main(String args[])
    {
        BookingFacade booking_object = new BookingFacade();
        booking_object.bookTickets(27, "Awaarapan 2", 750);
    }
}