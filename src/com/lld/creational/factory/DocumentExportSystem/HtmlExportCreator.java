package com.lld.creational.factory.DocumentExportSystem;

public class HtmlExportCreator extends ExportCreator{
    @Override
    public Document createDocument() {
        return new HtmlDocument();
    }
}
