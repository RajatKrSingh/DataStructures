package creational.factory;

public class Runner
{
    public static void main(String args[])
    {
        ClientService client;
        NotificationService notification_service;
        // Create Whatsapp client and send message
        client = new WhatsappClient();
        notification_service = client.create_notification_service();
        notification_service.send();

        // Create SMS client and send message
        client = new SMSClient();
        notification_service = client.create_notification_service();
        notification_service.send();
        
    }
}