package behavioural.observor.application;

import behavioural.observor.subscriber.*;
import behavioural.observor.publisher.*;
import java.util.*;

public class Application
{
    public Publisher publisher;
    private List<Subscriber> subscriber_list;
    public Application()
    {
        this.publisher = new Publisher();
        subscriber_list = new ArrayList<>();
        subscriber_list.add(new EmailSubscriber());
        subscriber_list.add(new SMSSubscriber());
        for(Subscriber subscriber: subscriber_list)
            publisher.subscribe("EventA", subscriber);
    }

    public void executeEventA()
    {
        publisher.notify("EventA");
    }

    public void removeSubscriber()
    {
        publisher.unsubscribe("EventA", subscriber_list.get(subscriber_list.size()-1));
    }
}