package com.lld.structural.composite.fileexplorer.compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class
 *
 * A folder is composite. It holds a list of FileSystemItem children and implements
 * each operation by delegating to them. It also provides addItem() and removeItem()
 * methods for managing children
 */
public class Folder implements FileSystemItem{
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void addItem(FileSystemItem item){
        children.add(item);
    }

    public void removeItem(FileSystemItem item){
        children.remove(item);
    }

    @Override
    public int getSize() {
        int total = 0;
        for(FileSystemItem item : children){
            total += item.getSize();
        }
        return total;
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "+ " + name + "/");
        for (FileSystemItem item : children){
            item.printStructure(indent + " ");
        }
    }

    @Override
    public void delete() {
        for (FileSystemItem item : children){
            item.delete();
        }
        System.out.println("Deleting folder: " + name);
    }
}
