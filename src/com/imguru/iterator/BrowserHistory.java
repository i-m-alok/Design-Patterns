package com.imguru.iterator;

import java.util.ArrayList;

public class BrowserHistory <T> {

    private ArrayList<T> browsingList = new ArrayList<>();

    public BrowserHistory(){
    }

    public void push(T url){
        browsingList.add(url);
    }

    public void pop(){
        int lastIndex = browsingList.size()-1;
        browsingList.remove(lastIndex);
    }

    public Iterator createIterator(){
        return new ListIterator(browsingList);
    }

    public T getBrowsingList (){
        return (T) browsingList;
    }
}
