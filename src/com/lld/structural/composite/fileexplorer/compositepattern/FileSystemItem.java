package com.lld.structural.composite.fileexplorer.compositepattern;

/**
 * Component interface
 * This is the shared contract
 * Both files (leaves) and folders (composites) implement it
 * Every operation that can be performed on the tree is declared here
 */
public interface FileSystemItem {
    int getSize();
    void printStructure(String indent);
    void delete();
}

/**
 * This interface ensures that all file system items
 * whether files or folders, expose the same behavior to the client
 * No type check is needed
 */