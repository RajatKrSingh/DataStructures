package creational.factory;

public class WhatsappNotificationService implements NotificationService
{
    @Override
    public void send()
    {
        System.out.println("Sending Whatsapp Notification");
    }
}