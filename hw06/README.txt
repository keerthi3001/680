------------------------------------------------------------
CS680 – HW6 (Composite Design Pattern with JUnit)
------------------------------------------------------------

This assignment implements a miniature in-memory File System
using the **Composite Design Pattern** and includes automated
unit testing with **JUnit 5**, integrated through **Apache Ant**
and **Ivy**.

The project models directories and files as hierarchical
objects that can be treated uniformly. A Singleton class
(FileSystem) manages multiple root directories, similar to
multiple drives in an operating system.

------------------------------------------------------------
Class Structure
------------------------------------------------------------
1. FSElement.java  (Abstract Superclass)
   - Common fields: name, size, creationTime, parent
   - Abstract method: isDirectory()

2. File.java
   - Represents a file (leaf node).
   - Inherits from FSElement.
   - Overrides isDirectory() → returns false.

3. Directory.java
   - Represents a directory (composite node).
   - Maintains LinkedList<FSElement> children.
   - Key methods:
       appendChild(), getChildren(),
       countChildren(), getFiles(),
       getSubDirectories(), getTotalSize()
   - getTotalSize() is recursive: sums all file sizes under
     a directory.

4. FileSystem.java (Singleton)
   - Manages multiple root directories.
   - getFileSystem(): returns the singleton instance.
   - appendRootDir(), getRootDirs().

------------------------------------------------------------
JUnit Test Structure
------------------------------------------------------------
All test classes are under `src/test/cs680/hw06`.

- **TestFixtureInitializer.java**
  Creates a reusable fixture (root/home/src directories with
  several files) using @BeforeAll.

- **FileTest.java**
  Verifies file properties (name, size, parent link, etc.)

- **DirectoryTest.java**
  Tests appendChild(), countChildren(), getTotalSize(),
  and equality based on directory metadata.

- **FileSystemTest.java**
  Confirms Singleton behavior and immutability of root list.

------------------------------------------------------------
Build & Run Instructions
------------------------------------------------------------
1. Open the terminal in this folder (`hw06`).
2. Run the following commands:

   ant clean          → Removes previous build artifacts  
   ant resolve        → Downloads dependencies (JUnit/Ivy)  
   ant compile        → Compiles source and test code  
   ant test           → Runs all JUnit test cases  
   ant build          → Compiles everything (same as compile)  
   ant jar            → Packages into dist/hw06.jar

------------------------------------------------------------
Expected Output
------------------------------------------------------------
When tests run successfully, you will see:

[junitlauncher] ✔ FileTest  
[junitlauncher] ✔ DirectoryTest  
[junitlauncher] ✔ FileSystemTest  
BUILD SUCCESSFUL

------------------------------------------------------------
Notes
------------------------------------------------------------
- `Directory.getSize()` always returns 0; `File.getSize()` returns its own size.  
- `getTotalSize()` sums only file sizes, not directories.  
- The project follows the Composite and Singleton design patterns strictly.  
- All tests use JUnit 5 and run through Ant using junitlauncher.

------------------------------------------------------------
End of File
------------------------------------------------------------
