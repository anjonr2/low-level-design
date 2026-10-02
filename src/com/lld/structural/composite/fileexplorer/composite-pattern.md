Modeling a File Explorer

Imagine you are building a file explorer(like Finder on macOS or File Explorer on windows)
The system needs to represent 
1. Files that have a name and a size
2. Folders that can hold files and other folders, nested to any depth

Goal is to support operations such as : 
getSize() : returns the total size of a file or folder (sum of all contents
for folders)

printStructure(): prints the name of the item with indentation
to show hierarchy

delete(): deletes a file or a folder and everything inside it

**Naive approach**

_A straightforward solution uses two separate classes
File and Folder with no shared interface. The folder stores its contents 
as generic objects and checks the type of each item before operating on it_
