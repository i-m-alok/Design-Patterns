package com.imguru.statepattern;

public class TextBox implements Tools{
    @Override
    public void mouseUp() {
        System.out.println("Draw a rectangle");
    }

    @Override
    public void mouseDown() {
        System.out.println("Give options to write");
    }
}
