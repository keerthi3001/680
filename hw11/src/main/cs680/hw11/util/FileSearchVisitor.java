package cs680.hw11.util;

import cs680.hw11.fs.Directory;
import cs680.hw11.fs.FSVisitor;
import cs680.hw11.fs.File;
import cs680.hw11.fs.Link;

import java.util.LinkedList;


public class FileSearchVisitor implements FSVisitor {

    private final String targetName;
    private LinkedList<File> found = new LinkedList<>();

    public FileSearchVisitor(String targetName) {
        this.targetName = targetName;
    }

    public LinkedList<File> getFoundFiles() {
        return found;
    }

    @Override
    public void visit(Directory dir) {
        
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(targetName)) {
            found.add(file);
        }
    }

    @Override
    public void visit(Link link) {
        
    }
}
