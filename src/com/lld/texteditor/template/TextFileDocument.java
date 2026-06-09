package com.lld.texteditor.template;

public class TextFileDocument extends AbstractDocument{
    @Override
    protected void readContent() {
        System.out.println("Reading content from text file");
    }

    @Override
    protected void writeContent() {
        System.out.println("Writing content to text file");
    }

    @Override
    protected void validate() {
        System.out.println("Validating text file content");
    }
}
