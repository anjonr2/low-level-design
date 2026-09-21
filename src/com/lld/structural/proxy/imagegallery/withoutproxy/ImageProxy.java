package com.lld.structural.proxy.imagegallery.withoutproxy;

public class ImageProxy  implements Image{
    private String fileName;
    private HighResolutionImage realImage;

    public ImageProxy(String fileName){
        this.fileName = fileName;
        System.out.println("ImageProxy created for "+ fileName + " . Real image not loaded yet. ");
    }

    @Override
    public void display() {
        if(realImage == null){
            System.out.println("ImageProxy: display() requested for "+ fileName + ". Loading high-resolution image..");
            realImage = new HighResolutionImage(fileName)
        }else {
            System.out.println("ImageProxy: Using cached high-resolution image for "+ fileName);
        }

        realImage.display();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
