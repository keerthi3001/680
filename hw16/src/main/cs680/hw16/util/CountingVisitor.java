package cs680.hw16.util;

import cs680.hw16.fs.*;

public class CountingVisitor implements FSVisitor {

    private int dirCount, fileCount, linkCount;

    public int getDirectoryCount() { return dirCount; }
    public int getFileCount() { return fileCount; }
    public int getLinkCount() { return linkCount; }

    public void visit(Directory d) { dirCount++; }
    public void visit(File f) { fileCount++; }
    public void visit(Link l) { linkCount++; }
}
