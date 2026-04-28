package cs680.hw11.util;

import cs680.hw11.fs.Directory;
import cs680.hw11.fs.FSVisitor;
import cs680.hw11.fs.File;
import cs680.hw11.fs.Link;

import java.util.LinkedList;


public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files = new LinkedList<>();

    public LinkedList<File> getFiles() {
        return files;
    }

    @Override
    public void visit(Directory dir) {
        
    }

    @Override
    public void visit(File file) {
        files.add(file);
    }

    @Override
    public void visit(Link link) {
        
    }
}
