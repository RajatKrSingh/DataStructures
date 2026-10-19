package creational.factory;

public class WhatsappClient implements ClientService
{
    @Override
    public NotificationService create_notification_service()
    {
        return new WhatsappNotificationService();
    }
}