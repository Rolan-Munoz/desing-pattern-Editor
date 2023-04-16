package com.kreitek.editor.commands;

import com.kreitek.editor.CareTaker;
import com.kreitek.editor.Command;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;
    private final CareTaker caretaker;

    public DeleteCommand(int lineNumber, CareTaker caretaker) {
        this.lineNumber = lineNumber;
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.remove(lineNumber);

        caretaker.addMemento(new Memento(documentLines));
        System.out.println("Saved new state");
    }
}
