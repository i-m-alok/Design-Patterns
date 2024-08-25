package com.imguru.observer;

public class ChartSubscriber implements Subscriber{

    private DataSource dataSource;
    public ChartSubscriber(DataSource ds){
        dataSource=ds;
    }
    @Override
    public void update() {
        System.out.println("ChartSubscriber: Updated value is " + dataSource.getValue());
    }
}
