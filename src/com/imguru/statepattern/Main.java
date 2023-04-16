package com.imguru.statepattern;

// Majorly we are polymorphism in state pattern
public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new TextBox());
        canvas.requestMouseUp();
        canvas.requestMouseDown();

    }
}
