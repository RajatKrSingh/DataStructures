package structural.facade.facade;

import structural.facade.service.*;

public class BookingFacade
{
    SeatService seatservice;
    PaymentService paymentservice;
    TicketService ticketservice;

    public BookingFacade()
    {
        seatservice = new SeatService();
        paymentservice = new PaymentService();
        ticketservice = new TicketService();
    }


    public void bookTickets(int seat, String movie, double amount)
    {
        if(seatservice.checkAvailability(seat, movie))
        {
            paymentservice.pay(amount);
            seatservice.reserveSeat(seat, movie);
            ticketservice.issue(seat, movie);
        }
    }
}