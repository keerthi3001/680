package umbcs680.hw08.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory extends FSElement {

    private final LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, creationTime);
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

    public List<FSElement> getChildren() {
        return new LinkedList<>(children); // defensive copy
    }

    // ---- tests require these ----

    public int countChildren() {
        return children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        return children.stream()
                .filter(FSElement::isDirectory)
                .map(e -> (Directory) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<File> getFiles() {
        return children.stream()
                .filter(e -> e instanceof File)
                .map(e -> (File) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<Link> getLinks() {
        return children.stream()
                .filter(e -> e instanceof Link)
                .map(e -> (Link) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    // DO NOT put @Override here (your FSElement probably doesn't declare getTotalSize)
    public int getTotalSize() {
        int fileBytes = getFiles().stream().mapToInt(File::getSize).sum();
        int subBytes = getSubDirectories().stream().mapToInt(Directory::getTotalSize).sum();
        // Links contribute 0 by design.
        return fileBytes + subBytes;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public int getSize() {
        return 0; // directory size is 0
    }

    // Visitor Pattern B: traversal happens here
    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement child : children) {
            child.accept(visitor);
        }
    }
}
