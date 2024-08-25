package com.imguru.observer;

public class Main {

    public static void main(String[] args) {

        DataSource cell = new DataSource();

        ChartSubscriber chart = new ChartSubscriber(cell);
        SheetSubscriber sheet = new SheetSubscriber(cell);

        cell.addSubscriber(chart);
        cell.setValue(10);
        cell.addSubscriber(sheet);
        cell.setValue(20);

    }
}
