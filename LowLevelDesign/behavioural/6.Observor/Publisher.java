package behavioural.observor.publisher;

import behavioural.observor.subscriber.Subscriber;
import java.util.*;

public class Publisher
{
    private Map<String, List<Subscriber>> subscriber_map;
    public Publisher()
    {
        subscriber_map = new HashMap<>();
    }

    public void subscribe(String eventType, Subscriber subscriber)
    {
        if(!subscriber_map.containsKey(eventType))
            subscriber_map.put(eventType, new ArrayList<>());
        List<Subscriber> subscriber_list = subscriber_map.get(eventType);
        subscriber_list.add(subscriber);
    }

    public void unsubscribe(String eventType, Subscriber subscriber)
    {
        List<Subscriber> subscriber_list = subscriber_map.getOrDefault(eventType, new ArrayList<>());
        subscriber_list.remove(subscriber);
    }

    public void notify(String eventType)
    {
        List<Subscriber> subscriber_list = subscriber_map.get(eventType);
        for(Subscriber subscriber: subscriber_list)
            subscriber.update(eventType);
    }
}