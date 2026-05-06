package cs680.hw16.fs;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {

    private final LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime time) {
        super(parent, name, 0, time);
        if (parent != null) parent.appendChild(this);
    }

    public void appendChild(FSElement child) {
        if (child == null) throw new IllegalArgumentException("child required");
        if (child.getParent() != null && child.getParent() != this) {
            child.getParent().children.remove(child); // reparent safely
        }
        child.setParent(this);
        children.add(child);
    }

    public LinkedList<FSElement> getChildren() {
        return new LinkedList<>(children);
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comp) {
        if (comp == null) throw new IllegalArgumentException("comparator required");
        LinkedList<FSElement> sorted = new LinkedList<>(children);
        sorted.sort(comp);
        return sorted;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        children.forEach(e -> {
            if (e.isDirectory()) dirs.add((Directory) e);
        });
        return dirs;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comp) {
        LinkedList<Directory> dirs = new LinkedList<>();
        getChildren(comp).forEach(e -> {
            if (e.isDirectory()) dirs.add((Directory) e);
        });
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        children.forEach(e -> {
            if (e.isFile()) files.add((File) e);
        });
        return files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comp) {
        LinkedList<FSElement> sorted = new LinkedList<>(children);
        sorted.sort(comp);

        LinkedList<File> files = new LinkedList<>();
        sorted.forEach(e -> {
            if (e.isFile()) files.add((File) e);
        });
        return files;
    }

    @Override public boolean isDirectory() { return true; }
    @Override public boolean isFile() { return false; }
    @Override public boolean isLink() { return false; }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        children.forEach(e -> e.accept(visitor));
    }
}
