CS680 - Homework 08
Name: Keerthi

--------------------------------------------------
1. How to compile and run tests
--------------------------------------------------

From the hw08 folder (where build.xml is located), run:

    ant clean test

This will:
  - Delete any previous build and lib directories.
  - Download Ivy and the required JUnit 5 libraries.
  - Compile all main source files under:
        src/main/cs680/hw08
  - Compile all test source files under:
        src/test/cs680/hw08
  - Run all JUnit tests.
  - Generate JUnit XML reports under:
        build/reports

If the build is successful, you should see:
    BUILD SUCCESSFUL

--------------------------------------------------
2. Files and structure
--------------------------------------------------

Main source code (production classes):

  src/main/cs680/hw08/fs/FSElement.java
      - Abstract base class for file system elements.
      - Stores common properties such as name, parent, and createdTime.

  src/main/cs680/hw08/fs/Directory.java
      - Represents a directory in the file system.
      - Extends FSElement.
      - Maintains a list of children (files, subdirectories, links).
      - Provides methods to add children and compute its total size.

  src/main/cs680/hw08/fs/File.java
      - Represents a regular file in the file system.
      - Extends FSElement and stores a size (in bytes).
      - isDirectory() returns false for File.

  src/main/cs680/hw08/fs/Link.java
      - Represents a link that refers to another FSElement (its target).
      - Extends FSElement.
      - Stores a reference to the target element.

  src/main/cs680/hw08/fs/FileSystem.java
      - Singleton-like class that holds a reference to the root directory
        of the file system.
      - Provides methods to get or set the root.

  src/main/cs680/hw08/fs/FSVisitor.java
      - Visitor interface for file system elements.
      - Declares visit methods for Directory, File, and Link.

  src/main/cs680/hw08/util/FileSearchVisitor.java
      - Concrete visitor implementation used to search for files by name.
      - Has a constructor that takes a target file name.
      - When visiting files, it adds matches to an internal results list.
      - Provides a getter to retrieve the list of matching files.

  src/main/cs680/hw08/TestFixtureInitializer.java
      - Helper class used to create a sample file system tree for testing.
      - Builds a root directory, some subdirectories, files, and links.

  src/main/cs680/hw08/SmokeTestMain.java (if present)
      - Optional small main program used for manual smoke testing.

Test code:

  src/test/cs680/hw08/SmokeTest.java
      - Very basic smoke test to confirm that the project builds and
        JUnit is configured correctly.

  src/test/cs680/hw08/fs/DirectoryTest.java
      - Tests Directory behavior, such as:
          * Adding children.
          * Correct parent/child relationships.
          * Directory size as the sum of its files’ sizes.

  src/test/cs680/hw08/fs/FileTest.java
      - Tests File basic properties:
          * Name, size, parent.
          * isDirectory() returns false.
          * File object is created correctly.

  src/test/cs680/hw08/fs/FileSystemTest.java
      - Tests FileSystem behavior:
          * Setting and getting the root directory.
          * Ensures the file system returns the expected root.

  src/test/cs680/hw08/fs/LinkTest.java
      - Tests Link behavior:
          * Link has the correct target.
          * Link inherits basic FSElement properties.
          * isDirectory() returns false for links (if implemented this way).

  src/test/cs680/hw08/util/FileSearchVisitorTest.java
      - Tests FileSearchVisitor:
          * Uses TestFixtureInitializer to construct a sample tree.
          * Runs the visitor to search for a specific file name.
          * Checks that the visitor returns the correct matching files.

--------------------------------------------------
3. Design overview
--------------------------------------------------

This homework models a simple file system with an object-oriented design:

  - FSElement is the common abstraction for directories, files, and links.
  - Directory aggregates children and can compute its total size.
  - File represents leaves in the tree with a fixed size.
  - Link points to another FSElement, allowing aliasing/sharing.

The Visitor pattern is used to traverse the file system:

  - FSVisitor defines the operations that can be performed on
    each type of element.
  - FileSearchVisitor is one concrete visitor that searches for files
    whose names match a given string.

The tests verify both the structure of the file system hierarchy and
the correct behavior of the visitor.

--------------------------------------------------
4. How to run a single test class (optional)
--------------------------------------------------

If needed, you can run an individual JUnit test by using the
junitlauncher with a specific test class, for example:

    ant test -Dtest=cs680.hw08.fs.DirectoryTest

(Only if the provided build.xml supports filtering; otherwise, use
`ant test` to run all tests.)

--------------------------------------------------
5. Notes
--------------------------------------------------

- This project uses Ant and Ivy to automatically download JUnit 5.
- All development and testing was done using:
    ant clean test
- All current tests pass successfully.
