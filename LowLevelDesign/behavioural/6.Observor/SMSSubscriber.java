package behavioural.observor.subscriber;

public class SMSSubscriber implements Subscriber
{
    @Override
    public void update(String eventType)
    {
        System.out.println("SMSSubsriber notified of event "+eventType);
    }
}