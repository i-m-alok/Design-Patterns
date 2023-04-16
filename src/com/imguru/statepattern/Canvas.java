package com.imguru.statepattern;

public class Canvas {

    Tools currentTool;

    public void requestMouseUp(){
        currentTool.mouseUp();
    }

    public void requestMouseDown(){
        currentTool.mouseDown();
    }

    public Tools getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tools currentTool) {
        this.currentTool = currentTool;
    }


}
