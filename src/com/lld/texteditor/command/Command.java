package com.lld.texteditor.command;

public interface Command {
    void execute();
    void undo();
}
