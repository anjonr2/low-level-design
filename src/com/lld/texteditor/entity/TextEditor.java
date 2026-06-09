package com.lld.texteditor.entity;

import com.lld.texteditor.command.Command;

import java.util.Stack;

/*
Facade class.
It's also a invoker of commands in the command design pattern
 */
public class TextEditor {
    private Document document;
    private Stack<Command> undoStack = new Stack<>();

    public TextEditor(Document document) {
        this.document = document;
    }

    //Executes a command and stores it for undo
    public void executeCommand(Command command){
        command.execute();
        undoStack.push(command);
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            Command command = undoStack.pop();
            command.undo();
        }
    }

    public void printDocument(){
        document.print();
    }
}
