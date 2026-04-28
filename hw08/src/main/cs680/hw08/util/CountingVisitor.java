package umbcs680.hw08.util;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.Link;
import umbcs680.hw08.fs.FSVisitor;

public class CountingVisitor implements FSVisitor {

    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;
    private int totalBytes = 0;
    private boolean includeLinkTargets;

    // default constructor (in case anything uses it)
    public CountingVisitor() {
        this(false);
    }

    //  This matches the tests: new CountingVisitor(false/true)
    public CountingVisitor(boolean includeLinkTargets) {
        this.includeLinkTargets = includeLinkTargets;
    }

    @Override
    public void visit(Directory dir) {
        dirNum++;
    }

    @Override
    public void visit(File file) {
        fileNum++;
        totalBytes += file.getSize();
    }

    @Override
    public void visit(Link link) {
        linkNum++;
        if (includeLinkTargets && link.getTarget() != null) {
            if (link.getTarget() instanceof File) {
                totalBytes += ((File) link.getTarget()).getSize();
            }
            // If it points to a directory, we ignore for this assignment.
        }
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }

    //  This is what the test is calling
    public int getTotalBytes() {
        return totalBytes;
    }
}
