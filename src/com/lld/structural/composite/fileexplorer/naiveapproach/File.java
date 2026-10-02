package com.lld.structural.composite.fileexplorer.naiveapproach;

public class File {
    private String name;
    private int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void printStructure(String indent){
        System.out.println(indent + name);
    }

    public void delete(){
        System.out.println("Deleting file: "+ name);
    }
}
