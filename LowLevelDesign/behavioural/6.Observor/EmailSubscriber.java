package behavioural.observor.subscriber;

public class EmailSubscriber implements Subscriber
{
    @Override
    public void update(String eventType)
    {
        System.out.println("EmailSubrcriber notified of event "+ eventType);
    }
}