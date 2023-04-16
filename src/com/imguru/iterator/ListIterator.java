package com.imguru.iterator;

import java.util.List;

public class ListIterator<T> implements Iterator{

    private int current=0;

    private List<T> list;

    public ListIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public <T> T next() {
        return (T) list.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current+1<=list.size();
    }
}
