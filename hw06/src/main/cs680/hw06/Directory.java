package cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory extends FSElement {
    private final LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        if (parent != null) { parent.appendChild(this); } // convenience link
    }

    @Override
    public boolean isDirectory() { return true; }

    public List<FSElement> getChildren() {
        return new LinkedList<>(children); // defensive copy
    }

    public void appendChild(FSElement child) {
        if (child == null) throw new IllegalArgumentException("child required");
        if (child.getParent() != null && child.getParent() != this) {
            child.getParent().children.remove(child); // reparent safely
        }
        child.setParent(this);
        this.children.add(child);
    }

    public int countChildren() { return children.size(); }

    public List<Directory> getSubDirectories() {
        return children.stream()
                .filter(FSElement::isDirectory)
                .map(e -> (Directory) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List<File> getFiles() {
        return children.stream()
                .filter(e -> !e.isDirectory())
                .map(e -> (File) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /** Total size contributed by all files under this directory (recursive). */
    public int getTotalSize() {
        int fileBytes = getFiles().stream().mapToInt(File::getSize).sum();
        int subBytes  = getSubDirectories().stream().mapToInt(Directory::getTotalSize).sum();
        return fileBytes + subBytes;
    }
}
