package com.imguru.iterator;

public class Main {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();

        history.push("abc");
        history.push("pqr");
        history.push("xyz");

        Iterator iterator = history.createIterator();
        while (iterator.hasNext()){
            String url = iterator.next();
            System.out.println(url);
        }
    }
}
