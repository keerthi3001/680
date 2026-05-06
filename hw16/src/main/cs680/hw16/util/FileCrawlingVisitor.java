package cs680.hw16.util;

import cs680.hw16.fs.*;
import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files = new LinkedList<>();
    public LinkedList<File> getFiles() { return files; }

    public void visit(Directory d) {}
    public void visit(File f) { files.add(f); }
    public void visit(Link l) {}
}
