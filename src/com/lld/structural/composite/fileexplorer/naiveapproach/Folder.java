package com.lld.structural.composite.fileexplorer.naiveapproach;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Object> contents = new ArrayList<>();

    public Folder(String name){this.name = name;}

    public void add(Object item){
        contents.add(item);
    }

    public int getSize(){
        int total = 0;
        for (Object item : contents){
            if(item instanceof File){
                total+=((File) item).getSize();
            }else if(item instanceof Folder){
                total+= ((Folder) item).getSize();
            }
        }
        return total;
    }

    public void printStructure(String indent){
        System.out.println(indent + name + "/");
        for (Object item : contents){
            if(item instanceof File){
                ((File) item).printStructure(indent + " ");
            }else if(item instanceof Folder){
                ((Folder) item).printStructure(indent+" ");
            }
        }
    }

    public void delete(){
        for (Object item : contents){
            if(item instanceof File){
                ((File) item).delete();
            } else if (item instanceof Folder) {
                ((Folder) item).delete();
            }
        }
        System.out.println("Deleting folder: "+ name);
    }
}

/**
 * What's wrong with this approach
 *
 * As the structure grows more complex, this solution introduces
 * several critical problems:
 *
 * 1.Repetitive Type Checks
 * Every operation (getSize(), printStructure(), delete()) requires
 * instanceOf checks and downcasting. This logic is duplicated across every
 * method that touches the tree
 *
 * 2.No shared abstraction
 * There is no common interface for File and Folder, so we cannot write generic code like
 * List<FileSystemItem> items = List.of(file, folder);
 *
 * for(FileSystemItem item : items){
 *     item.delete()
 * }
 *
 * 3.Violation of Open/closed principle
 * To add new item types (say shortcut or compressed folder) you must modify the
 * type-checking logic in every existing method. Each new type means touching
 * every operation in the Folder class
 *
 * 4. Fragile recursive logic
 * Computing sizes or deleting deeply nested structures becomes a tangled mess of
 * nested conditionals and type-specific recursive calls. One missed type check and item
 * silently disappears from the total
 *
 * What we really need
 * We need a solution that :
 * 1.Introduces a common interface (e.g: FileSystemItem) for all components
 * 2.Allows files and folders to be treated uniformly via polymorphism
 * 3.Supports recursive operations without type check
 * 4.Makes the system with easy to extend with new item types
 *
 * This is exactly the kind of problem the Composite Design Pattern is made for
 *
 * The composite pattern is a structural pattern that composes objects
 * into tree structures and lets clients treat individual objects and compositions
 * uniformly
 *
 * Two characteristic define the pattern
 * 1. Uniform interface : Both leaf objects (no children) and composite
 * objects (contain children) implement the same interface. The client
 * calls the same methods regardless of which type it is working with
 *
 * 2. Recursive composition : A composite holds a collection of components,
 * which can themselves be composites
 *
 * The structure involves four participants:
 *
 * Component Interface (e.g : FileSystemItem)
 *
 * The shared interface that declares operations common to both leave and
 * composites
 *
 * In our file system example
 * FileSystemItem declares
 * getSize(), printStructure() and delete(). Every file and folder
 * implements these methods
 *
 * Leaf (e.g : File)
 * An end object in the tree that has no children. It implements the component interface
 * directly
 *
 * In our example, File is a leaf. It returns its own size
 * prints its own name and deletes itself. No delegation, no children
 *
 * Composite (e.g., Folder)
 * A container that holds child components and implements the Component interface by
 * delegating to its children
 *
 * In our example
 * Folder stores a list of FileSystem objects. Its getSize() sums the size of all children
 * Its printStructure() prints its own name then asks each child to print
 * Its delete() deletes all children then itself
 *
 * Client(FileExplorerApp)
 * Works with the tree through Component interface, without knowing whether it holds a leaf
 * or a composite
 *
 * How it works
 *
 * Here is the composite workflow, step by step, using our file system example
 *
 * Step 1 : Build the tree
 *
 * The client creates leaf objects(files) and composite objects(folders), then
 * adds leaves and composites to the appropriate parents
 *
 * Step 2 : Call on operation on the root
 *
 * The client calls getSize() on the root folder. It does not need to know the
 * internal structure
 *
 * Step 3 : The composite delegates to its children
 *
 * The root folder iterates over its children, calling getSize() on each one
 *
 * Step 4: Leaves return their values directly
 *
 * when getSize() reaches a file, the file returns its size.No delegation, no recursion
 *
 * Step 5 : Nested composite recurse
 *
 * when getSize() reaches a subfolder, that folder iterates over its children, calling
 * getSize() on each. This continues until every leaf is reached
 *
 * Step 6 : Results aggregate up the tree
 *
 * Each composite sums the values returned by its children and returns the total
 * The root folder returns the sum of all files in the entire tree
 */