package com.lld.texteditor.command;

import com.lld.texteditor.entity.Document;

public class DeleteCommand implements Command{
    private final Document document;
    private final int rowIndex;
    private String deletedText;

    public DeleteCommand(Document document, int rowIndex) {
        this.document = document;
        this.rowIndex = rowIndex;
    }

    @Override
    public void execute() {
        deletedText = document.getLine(rowIndex);
        document.deleteLine(rowIndex);
    }

    @Override
    public void undo() {
        document.insertLine(rowIndex, deletedText);
    }
}
