package com.lld.texteditor.application;

import com.lld.texteditor.command.InsertCommand;
import com.lld.texteditor.entity.Document;
import com.lld.texteditor.entity.TextEditor;

//driver code
public class TextEditorClient {
    public static void main(String []args){
        Document document = new Document();
        TextEditor textEditor = new TextEditor(document);

        textEditor.executeCommand(new InsertCommand(document, 0, "First text"));
        textEditor.executeCommand(new InsertCommand(document, 1, "This is a text editor"));
        textEditor.printDocument();

        System.out.println("Undoing last action...");
        textEditor.undo();
        textEditor.printDocument();
    }
}
