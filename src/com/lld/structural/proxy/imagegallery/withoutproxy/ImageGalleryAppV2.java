package com.lld.structural.proxy.imagegallery.withoutproxy;

/**
 * Uses proxy pattern
 */
public class ImageGalleryAppV2 {
    public static void main(String [] args){
        System.out.println("Application started. Initializing image proxies for gallery...");

        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");
        Image image3 = new ImageProxy("photo3.jpg");

        System.out.println("\nGallery initialized. No image actually loaded yet.");
        System.out.println("Image 1 file name: "+image1.getFileName());

        System.out.println("\nUser requests to display "+ image1.getFileName());
        image1.display();

        System.out.println("\nUser requests to display "+ image1.getFileName() + " again ");
        image1.display();

        System.out.println("\nUser requests to display "+ image3.getFileName());
        image3.display();

        System.out.println("\nApplication finished. Note: photo2.png was never loaded");

    }
}

/**
 * What we achieved with proxy pattern:
 *
 * Lazy loading : Images are only loaded when the user actually views them, cutting
 * startup time from 6 seconds to near instant
 *
 * Memory saving : photo2.png was never loaded, saving extra 10MB of memory
 *
 * Same interface : The client code uses Image references throughout, unware of the proxy
 *
 * No changes to the real object : HighResolutionImage was not modified at all
 *
 * Cached access : The second display() call on photo1.jpg reuses the already-loaded image with
 * no delay
 */