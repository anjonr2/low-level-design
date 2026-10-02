package com.lld.structural.composite.fileexplorer.compositepattern;

/**
 * Create the leaf class (File)
 *
 * A file is a leaf node. It implements the component interface directly
 * returning its own values without delegating to children
 */
public class File implements FileSystemItem{
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "- "+ name + "(" + size + " KB)");
    }

    @Override
    public void delete() {
        System.out.println("Deleting file: "+ name);
    }
}

/**
 * Each file is a leaf node. It has no children no delegation. It just returns its own data
 */