package com.kreitek.editor.commands;

import com.kreitek.editor.CareTaker;
import com.kreitek.editor.Command;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private final CareTaker caretaker;


    public AppendCommand(String text, CareTaker caretaker) {
        this.text = text;
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.add(text);
        caretaker.addMemento(new Memento(documentLines));
        System.out.println("Saved new state");
    }
}
