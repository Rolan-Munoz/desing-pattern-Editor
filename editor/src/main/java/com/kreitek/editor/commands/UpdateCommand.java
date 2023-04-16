package com.kreitek.editor.commands;

import com.kreitek.editor.CareTaker;
import com.kreitek.editor.Command;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;
    private final CareTaker caretaker;

    public UpdateCommand(String text, int lineNumber, CareTaker caretaker) {
        this.text = text;
        this.lineNumber = lineNumber;
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
        caretaker.addMemento(new Memento(documentLines));
        System.out.println("Saved new state");
    }
}
