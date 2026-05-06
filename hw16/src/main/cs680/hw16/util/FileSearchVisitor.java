package cs680.hw16.util;

import cs680.hw16.fs.*;
import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    private String name;
    private LinkedList<File> found = new LinkedList<>();

    public FileSearchVisitor(String name) {
        this.name = name;
    }

    public LinkedList<File> getFoundFiles() { return found; }

    public void visit(Directory d) {}
    public void visit(File f) {
        if (f.getName().equals(name)) found.add(f);
    }
    public void visit(Link l) {}
}
