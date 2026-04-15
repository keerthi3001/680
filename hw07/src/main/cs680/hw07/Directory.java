package cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Directory extends FSElement {

    private final LinkedList<FSElement> children = new LinkedList<>();

    /**
     *  Constructor that matches the tests:
     * new Directory(parent, "name", time)
     */
    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        // Directory's own size can be treated as 0.
        super(parent, name, 0, creationTime);
        if (parent != null) {
            parent.appendChild(this);
        }
    }

    /**
     * Optional constructor with explicit size
     * (kept in case any main code uses it).
     */
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        // Still treat directories as size 0 per HW7 spec.
        super(parent, name, 0, creationTime);
        if (parent != null) {
            parent.appendChild(this);
        }
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
                .filter(FSElement::isFile)
                .map(e -> (File) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**  Needed by DirectoryTest */
    public LinkedList<Link> getLinks() {
        return children.stream()
                .filter(FSElement::isLink)
                .map(e -> (Link) e)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /** Often used to compute total size of a directory subtree. */
    public int getTotalSize() {
        int fileBytes = getFiles().stream().mapToInt(File::getSize).sum();
        int subBytes = getSubDirectories().stream().mapToInt(Directory::getTotalSize).sum();
        // Links contribute 0 bytes by design (their FSElement.size is 0).
        return fileBytes + subBytes;
    }
}
