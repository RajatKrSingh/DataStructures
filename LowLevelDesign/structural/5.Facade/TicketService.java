package structural.facade.service;

public class TicketService
{
    public void issue(int seat, String movie)
    {
        System.out.println("Seat "+ seat+" issued for movie "+movie);
    }
}