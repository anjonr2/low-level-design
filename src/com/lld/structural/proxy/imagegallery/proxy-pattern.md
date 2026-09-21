ImageGalleryApp

without proxy implementation

What's wrong with this implementation?

1. Resource intensive initialization 
   - Every high resolution image loads its image data at the time of construction, even if the user never views
   - the image. This leads to slow application startup, unnecessary memory consumption and wasted I/O bandwidth. 
   - If the gallery has to display hundreds of thumbnails, this approach quickly becomes a bottleneck

2. No control over access
   - What if you want to log every time an image is actually displayed?
   - Add permission checks before loading a sensitive image
   - Cache previously loaded images for reuse

Right now, we have to modify HighResolutionImage class directly, mixing responsibilities 
and breaking the single responsibility principle

What we really need

We need a solution that allows us to : 

1. Defer the expensive loading of image data until it's actually needed
2. Add extra behaviors like logging, access control, or caching without changing
the existing HighResolutionImage class
3. Maintain the same interface so that the client code doesn't need to change


Using proxy pattern -

Proxy has four participants 

Subject(e.g : Image)
The common interface that both the real object and the proxy implement

In our image gallery example, Image is the subject. It declares display()
and getFileName() methods that every participant implements

RealSubject(e.g : HighResolutionImage)
The actual object that performs the real, expensive work

In our example, HighResolutionImage loads a 10MB image from disk
during construction. It is the object we want to defer creating until
absolutely necessary

Proxy(e.g: ImageProxy)

A lightweight stand-in that implements the Subject interface and controls
access to the RealSubject

In our example , ImageProxy stores the filename but does not create
a HighResolutionImage until display() is called. It can answer getFileName()
without loading anything

Client(e.g: ImageGalleryApp)
The consumer that works with objects through the subject interface

In our example, the gallery app creates Image references and calls display() on whichever
images the user clicks. It does not know or care whether those references point to proxies
or real image

The ImageProxy implements the same Image interface as HighResolutionImage
so the client can use it interchangeably. Internally, it stores filename
and only creates the real image when display() is called