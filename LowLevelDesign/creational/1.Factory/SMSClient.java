package creational.factory;

public class SMSClient implements ClientService
{
    @Override
    public NotificationService create_notification_service()
    {
        return new SMSNotificationService();
    }
}