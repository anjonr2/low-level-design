package com.lld.creational.factory.DocumentExportSystem;

//Product interface
public interface Document {
    String getHeader();
    String formatRow(String [] data);
    String getFooter();
    String getFileExtension();
}
