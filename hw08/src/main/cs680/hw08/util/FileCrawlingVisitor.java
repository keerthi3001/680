package umbcs680.hw08.util;

import java.util.LinkedList;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.FSElement;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.Link;
import umbcs680.hw08.fs.FSVisitor;

public class FileCrawlingVisitor implements FSVisitor {

    private final LinkedList<String> absolutePaths = new LinkedList<>();

    public FileCrawlingVisitor() {
    }

    @Override
    public void visit(Directory dir) {
        // Do nothing for directories in this visitor
    }

    @Override
    public void visit(File file) {
        absolutePaths.add(buildAbsolutePath(file));
    }

    @Override
    public void visit(Link link) {
        // We ignore links for this visitor so that
        // the size in the test is exactly the number of real files.
    }

    private String buildAbsolutePath(FSElement elem) {
        LinkedList<String> parts = new LinkedList<>();
        FSElement cur = elem;
        while (cur != null) {
            parts.addFirst(cur.getName());
            cur = cur.getParent();
        }
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            sb.append("/").append(p);
        }
        return sb.toString();
    }

    //  This is what the tests call: v.getAbsolutePaths()
    public LinkedList<String> getAbsolutePaths() {
        return new LinkedList<>(absolutePaths); // defensive copy
    }
}
