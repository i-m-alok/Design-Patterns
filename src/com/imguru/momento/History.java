package com.imguru.momento;

import java.util.Stack;

public class History {
    private Stack<EditorState> states = new Stack<>();

    public EditorState pop() {
        return states.pop();
    }

    public void push(EditorState state) {
        states.push(state);
    }
}
