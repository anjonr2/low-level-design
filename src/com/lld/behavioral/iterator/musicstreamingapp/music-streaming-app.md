Imagine you're building a music streaming application. Users can create 
playlists, add songs and play them in various ways. 
A playlist might contain hundreds of songs, and the player needs to iterate
through them one by one

Understanding the iterator Pattern 

The Iterator pattern defines a separate object, the iterator, that encapsulates
the details of traversing a collection. Instead of exposing its internal
structure, the collection provides an iterator that clients use to access
elements sequentially

Two characteristic define the pattern : 

1. Separation of traversal from storage : The collection knows how to store elements. The iterator knows how to walk 
through them. These two concerns live in separate classes 
so you can change one without affecting the other

2. Multiple independent traversals : Each call to createIterator() returns
a new, independent iterator with its own position. Multiple clients 
can traverse the same collection simultaneously without interfering with each other


Real world analogy 

Consider a TV remote control. When you press the "next channel" button, you
do not need to know how the TV internally organizes its channel list. May be
it is stored in an array, a linked list

The remote provides a simple interface : next channel, previous channel. The complexity
of channel management is hidden behind that interface

The iterator pattern works the same way. The iterator is like the remote control
providing a simple interface to move through a collection without exposing how
that collection is structured internally


Iterator pattern involves four key components: 

1. Iterator (interface)

Declares the operations required to traverse a collection. At minimum, this
includes hasNext() to check if more elements exist and next() to retrieve 
the next element

2. ConcreteIterator 

Implements the iterator interface for a specific collection.
It maintains the current position within the collection and knows how
to move to the next element

3. IterableCollection (interface)

Declares a method for creating iterator. Any class implementing this interface 
promises it can be iterated

4. ConcreteCollection

Implements the IterableCollection interface. It stores elements and returns 
an appropriate iterator when asked

Why a Separate Iterator object?

We might wonder why we need a separate iterator object. Why not just add 
hasNext() and next() methods directly to the collection?

The answer lies in supporting multiple simultaneous traversals. If the 
collection itself tracks the current position, you can have only one traversal
at a time. But with separate iterator objects, you can have multiple iterators
traversing the same collection independently

This becomes important in multi threaded applications or when you need
to compare elements at different positions in the same collection

How Iterator Pattern works 

The iterator workflow has five steps : 

Step 1 : The client asks the collection for an iterator by calling createIterator()

Step 2 : The collection creates a new iterator object, passing itself(or it's data) 
to the iterator's constructor

Step 3 : The iterator initializes its internal position to the begining of the
collection

Step 4 : The client uses the iterator in a loop: call hasNext() to check for
more elements, the next() to get the current element and advance

Step 5 : When hasNext() return false, traversal is complete 

