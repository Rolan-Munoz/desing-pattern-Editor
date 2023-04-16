package com.kreitek.editor;

import java.util.Stack;

public class CareTaker {
    private Stack<Memento> mementos = new Stack<>();

    public void addMemento(Memento memento) {
        mementos.push(memento);
    }

    public Memento restore() {
        if (mementos.isEmpty()) {
            return null;
        }
        return mementos.pop();
    }

    public Memento pop() {
        return mementos.pop();
    }
}
