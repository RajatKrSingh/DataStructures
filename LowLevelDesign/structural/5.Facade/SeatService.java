package structural.facade.service;

public class SeatService
{
    public boolean checkAvailability(int seat, String movie)
    {
        System.out.println("Seat "+ seat+ " available for movie "+movie);
        return true;
    }
    public void reserveSeat(int seat, String movie)
    {
        System.out.println("Seat "+ seat + " reserved for movie "+ movie);
    }
}