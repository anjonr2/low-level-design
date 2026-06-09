package com.lld.texteditor.template;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDocument {
    protected List<String> content = new ArrayList<>();

    public final void loadDocument(String filePath){
        //common steps to load a document
        System.out.println("Loading document from: " + filePath);
        openFile(filePath)
        readContent();
        validate();
        closeFile();
    }

    public final void saveDocument(String filePath){
        openFile(filePath);
        writeContent();
        validate();
        closeFile();
    }

    //Common step - Implemented once
    protected void openFile(String filePath){
        //actual logic reads file from the filePath. For demo purpose println is used
        System.out.println("Opening file: " + filePath);
    }

    protected void closeFile(){
        System.out.println("Closing file");
    }

    /*
        Document specific steps - To be implemented by subclasses
     */
    protected abstract void readContent();
    protected abstract void writeContent();
    protected abstract void validate();
}
