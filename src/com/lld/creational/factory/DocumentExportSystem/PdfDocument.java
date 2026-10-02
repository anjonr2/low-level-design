package com.lld.creational.factory.DocumentExportSystem;

public class PdfDocument implements Document{
    @Override
    public String getHeader() {
        return "--- PDF DOCUMENT START ---";
    }

    @Override
    public String formatRow(String[] data) {
        return "|" + String.join("|", data) + "| ";
    }

    @Override
    public String getFooter() {
        return "--- PDF DOCUMENT END ---";
    }

    @Override
    public String getFileExtension() {
        return ".pdf";
    }
}
