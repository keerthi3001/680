package cs680.hw11.util;

import cs680.hw11.fs.Directory;
import cs680.hw11.fs.FSVisitor;
import cs680.hw11.fs.File;
import cs680.hw11.fs.Link;


public class CountingVisitor implements FSVisitor {

    private int directoryCount;
    private int fileCount;
    private int linkCount;

    public int getDirectoryCount() {
        return directoryCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getLinkCount() {
        return linkCount;
    }

    @Override
    public void visit(Directory dir) {
        directoryCount++;
    }

    @Override
    public void visit(File file) {
        fileCount++;
    }

    @Override
    public void visit(Link link) {
        linkCount++;
    }
}
