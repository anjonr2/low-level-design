package com.lld.creational.factory.DocumentExportSystem;

public class HtmlDocument implements Document{
    @Override
    public String getHeader() {
        return "<html><body><table>";
    }

    @Override
    public String formatRow(String[] data) {
        StringBuilder sb = new StringBuilder("<tr>");
        for(String cell : data){
            sb.append("<td>").append(cell).append("</td>");
        }
        sb.append("</tr>");
        return sb.toString();
    }

    @Override
    public String getFooter() {
        return "</table></body></html>";
    }

    @Override
    public String getFileExtension() {
        return ".html";
    }
}
