Text editor supports typing text and deleting the last N characters

Entity---
TextEditor can be implemented as a Facade class. It's responsibilities include
interaction with user , deleting any requests to other components

This text editor class does not store text directly - delegates to documents

Document (Abstract Base class) ---
Responsibility - Stores text and manages file operations

Variants
 - ListDocument ( List of Strings)
 - RopeDocument (Large documents are stored as rope data strucutre. Rope is a binary tree where each leaf node contains a string and a length.)
 - PieceTableDocument (piece table model)

Above variants tells us that methods of storing documents can be different
Each document type manages its own storage and load/save logic.
Future addition of any document type does not affect TextEditor class, as it interacts with documents through a common interface.

Key methods
 - load(filePath) 
 - save(filePath)
 - getLines(star, end)
 - removeLines(start, end)
 - insertLines(position, lines)

Design pattern Role : 
Template method can be applied here for file I/O
Since all document types will have similar steps for loading and saving files, 
we can define a template method in the Document base class that outlines the steps for these operations. 
Each document type can then implement the specific details of how they read and write data, 
while the overall structure of the file I/O process remains consistent across all document types.

Cursor ---------

Responsibility : Manages the position of the cursor in the text editor. It keeps track of the current line and column, allowing for navigation and editing operations.

Reasoning : Keeps TextEditor class focused on high-level operations, 
while Cursor handles the specifics of cursor movement and position tracking. 
This separation of concerns allows for cleaner code and easier maintenance.

key methods
-move(line, column)
-select(rowStart, rowEnd)
-clearSelection()


ClipBoard -----------
Responsibility : Manages the clipboard functionality, allowing users to copy, cut, and paste text within the editor. 
Stores copied or cut text temporarily

Reasoning 
Keeps Clipboard functionality separate from TextEditor

key methods
-setContent(lines)
-getContent()

Design pattern : Can implement using Singleton pattern so that we have one clipboard per instance

Command Pattern
Responsibility : Encapsulates each user action as a command

Reason : 
Allows for undo/redo functionality
Keeps operation loosely coupled

Example Commands
CopyCommand, CutCommand, PasteCommand, MoveCursorCommand

Structure
execute() method in each command class performs the action
undo() method in each command class reverses the action

Template Method Pattern in Document
Where used :
File I/O operations in Document class

Why used : 
Process for saving is 
 - Open file
 - Write content
 - Close file

Fixed skeleton , but different document formats implements it in their own way

Benefits 
Consistency: All document types follow the same open-write-validate-close  structure 
Code reuse : Common steps implemented once in base class
Extensibility : New file types only override the steps that differ