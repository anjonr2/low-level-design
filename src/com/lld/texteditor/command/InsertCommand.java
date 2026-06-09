package com.lld.texteditor.command;

import com.lld.texteditor.entity.Document;

/*
InsertCommand is a concrete command class. It inserts any input text in the document
So we will store the document object which is a receiver here.
 */
public class InsertCommand  implements Command{
    private Document document;
    private int rowIndex;
    private String text;

    public InsertCommand(Document document, int rowIndex, String text) {
        this.text = text;
        this.document = document;
        this.rowIndex = rowIndex;
    }

    @Override
    public void execute() {
        document.insertLine(rowIndex, text);
    }

    @Override
    public void undo() {
        document.deleteLine(rowIndex);
    }
}
