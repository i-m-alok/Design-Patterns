package com.imguru.iterator;

public interface Iterator {

    /*
        this method give us the next value
    */
    public <T> T next();

    /*
        this method will tell us is there any next value exist or not
    */
    public boolean hasNext();

}
