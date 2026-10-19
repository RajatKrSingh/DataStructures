package creational.factory;

public class SMSNotificationService implements NotificationService
{
    @Override
    public void send()
    {
        System.out.println("Sending SMS Notification");
    }
}