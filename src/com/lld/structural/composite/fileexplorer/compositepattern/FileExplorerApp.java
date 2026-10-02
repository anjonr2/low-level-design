package com.lld.structural.composite.fileexplorer.compositepattern;

public class FileExplorerApp {
    public static void main(String [] args){
        FileSystemItem file1 = new File("readme.txt", 5);
        FileSystemItem file2 = new File("photo.jpg", 1500);
        FileSystemItem file3 = new File("data.csv", 300);

        Folder documents = new Folder("Documents");
        documents.addItem(file1);
        documents.addItem(file3);

        Folder pictures = new Folder("Pictures");
        pictures.addItem(file2);

        Folder home = new Folder("Home");
        home.addItem(documents);
        home.addItem(pictures);

        System.out.println("---- File Structure ----");
        home.printStructure("");

        System.out.println("Total size: "+ home.getSize() + " KB");

        System.out.println("\n---- Deleting All ----");
        home.delete();
    }
}

/**
 * What we achieved with this Composite?
 *
 * Unified treatment : Files and Folders share a common interface, allowing polymorphism
 *
 * Clean recursion : No instanceOf, no casting -- just delegation
 *
 * Scalability : Easily supports deeply nested structures
 *
 * Maintainability : Adding a new file type (e.g Shortcut , CompressedFolder) is easy
 *
 * Extensibility : New operations can be added via interfaceextension
 */
