package com.lld.creational.factory.DocumentExportSystem;

public abstract class ExportCreator {
    public abstract Document createDocument();

    public void export(String [][] data){
        Document document = createDocument();
        System.out.println("Exporting to "+ document.getFileExtension()+" format....");

        String header = document.getHeader();
        if(!header.isEmpty()){
            System.out.println(header);
        }

        for(String[] row : data){
            System.out.println(document.formatRow(row));
        }

        String footer = document.getFooter();
        if(!footer.isEmpty()){
            System.out.println(footer);
        }

        System.out.println("Export complete.\n");
    }
}
