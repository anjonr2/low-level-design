package com.lld.texteditor.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a document in the text editor. It can contain the content of the document,
 * It is also the Receiver class
 */
public class Document {
    //stores the lines
    private List<String> lines = new ArrayList<>();

    //inserts the text in the given rowIndex
    public void insertLine(int rowIndex, String text){
        lines.add(rowIndex, text);
    }

    public void deleteLine(int rowIndex){
        lines.remove(rowIndex);
    }

    public String getLine(int rowIndex){
        return lines.get(rowIndex);
    }

    //reads all the lines present in the document and returns
    public List<String> getLines(){
        return new ArrayList<>(lines);
    }

    public void setLines(List<String> newLines){
        lines = new ArrayList<>(newLines);
    }

    public void print(){
        for(int i=0; i<lines.size(); i+=1){
            System.out.println((i+1) + ": "+lines.get(i));
        }
    }
}

