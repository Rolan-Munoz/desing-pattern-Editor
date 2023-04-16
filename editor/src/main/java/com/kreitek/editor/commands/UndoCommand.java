package com.kreitek.editor.commands;

import com.kreitek.editor.CareTaker;
import com.kreitek.editor.Command;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private final CareTaker caretaker;

    public UndoCommand(CareTaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        Memento previousState = caretaker.restore();
        if (previousState != null) {
            documentLines.clear();
            documentLines.addAll(previousState.getState());
        }
    }
}
