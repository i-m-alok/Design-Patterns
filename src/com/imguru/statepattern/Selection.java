package com.imguru.statepattern;

public class Selection implements Tools{
    @Override
    public void mouseUp() {
        System.out.println("Current tool is Selection tool");
    }

    @Override
    public void mouseDown() {
        System.out.println("Select something");
    }
}
