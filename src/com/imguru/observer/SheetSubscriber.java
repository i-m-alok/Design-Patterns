package com.imguru.observer;

public class SheetSubscriber implements Subscriber{

    private DataSource dataSource;
    public SheetSubscriber(DataSource ds){
        dataSource=ds;
    }
    @Override
    public void update() {
        System.out.println("SheetSubscriber: Updated value is " + dataSource.getValue());
    }
}
