package com.imguru.iterator;


public class ArrayIterator<T> implements Iterator{

    private int current = 0;

    private T [] historyArray;

    public ArrayIterator(T[] historyArray) {
        this.historyArray = historyArray;
    }

    @Override
    public <T> T next() {
        return (T) historyArray[current++];
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
