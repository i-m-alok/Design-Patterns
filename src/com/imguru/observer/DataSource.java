package com.imguru.observer;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Integer value;
    private List<Subscriber> subscribers;

    public DataSource(){
        value = 0;
        subscribers = new ArrayList<>();
    }
    public void setValue(Integer val){
        System.out.println("value is changed in DataSource");
        this.value = val;
        this.notifySubscribers();
    }

    public Integer getValue(){
        return this.value;
    }

    public void addSubscriber(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }


    public void notifySubscribers(){
        System.out.println("Notifying subscribers");
        for(Subscriber s: subscribers){
            s.update();
        }
    }

}
