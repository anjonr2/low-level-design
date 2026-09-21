package com.lld.structural.proxy.imagegallery.withoutproxy;

public class ImageGalleryAppV1 {
    public static void main(String[] args){
        System.out.println("Application started. Initializing image for gallery...");
        Image image1 = new HighResolutionImage("photo1.jpg");
        Image image2 = new HighResolutionImage("photo2.jpg");
        Image image3 = new HighResolutionImage("photo3.jpg");

        System.out.println("\nGallery initialized. User can view images now...");

        System.out.println("User requests to display: "+ image1.getFileName());
        image1.display();

        System.out.println("User requests to display: "+ image2.getFileName());
        image2.display();

        System.out.println("User requests to display: "+ image3.getFileName());
        image3.display();

        System.out.println("\nApplication finished");
    }
}
