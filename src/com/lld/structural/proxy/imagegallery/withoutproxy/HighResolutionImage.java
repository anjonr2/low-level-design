package com.lld.structural.proxy.imagegallery.withoutproxy;

public class HighResolutionImage implements Image{
    private String fileName;
    private byte[] imageData;

    public HighResolutionImage(String fileName){
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: "+ fileName + " from disk (Expensive operation)..... ");
        try{
            Thread.sleep(200);
            this.imageData = new byte[10 * 1024 * 1024]; // Simulating a 10MB image
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Image "+ fileName + " loaded successfully.");
    }
    @Override
    public void display() {
        System.out.println("Displaying image: "+ fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
