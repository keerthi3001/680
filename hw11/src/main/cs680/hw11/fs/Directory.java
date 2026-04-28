package cs680.hw11.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;


public class Directory extends FSElement {

    private final LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        // directory size itself is 0; total size is sum of children
        super(parent, name, 0, creationTime);
        if (parent != null) {
            parent.appendChild(this);
        }
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
        return getChildren(new AlphabeticalComparator());
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> cmp) {
        if (cmp == null) throw new IllegalArgumentException("comparator required");
        LinkedList<FSElement> copy = new LinkedList<>(children); // defensive copy
        copy.sort(cmp);
        return copy;
    }

    public LinkedList<Directory> getSubDirectories() {
        return getSubDirectories(new AlphabeticalComparator());
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> cmp) {
        return getChildren(cmp).stream()
                .filter(FSElement::isDirectory)
                .map(e -> (Directory) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<File> getFiles() {
        return getFiles(new AlphabeticalComparator());
    }

    public LinkedList<File> getFiles(Comparator<FSElement> cmp) {
        return getChildren(cmp).stream()
                .filter(FSElement::isFile)
                .map(e -> (File) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<Link> getLinks() {
        return getLinks(new AlphabeticalComparator());
    }

    public LinkedList<Link> getLinks(Comparator<FSElement> cmp) {
        return getChildren(cmp).stream()
                .filter(FSElement::isLink)
                .map(e -> (Link) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /** Total size contributed by all files under this directory (recursive). */
    public int getTotalSize() {
        int fileBytes = getFiles(new AlphabeticalComparator()).stream().mapToInt(File::getSize).sum();
        int subBytes = getSubDirectories(new AlphabeticalComparator()).stream().mapToInt(Directory::getTotalSize).sum();
        // Links contribute 0 by design.
        return fileBytes + subBytes;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement child : children) {
            child.accept(visitor);
        }
    }
}
