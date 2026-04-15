package cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {

    protected Directory parent; // null for root dirs
    protected final String name;
    protected final int size; // 0 for directories and links (HW7 slide)
    protected final LocalDateTime creationTime;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (size < 0) throw new IllegalArgumentException("size must be >= 0");
        if (creationTime == null) throw new IllegalArgumentException("creationTime required");
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /** Is this element a directory? */
    public boolean isDirectory() {
        return false;
    }

    /** Is this element a regular file? */
    public boolean isFile() {
        return false;
    }

    /** Is this element a link? */
    public boolean isLink() {
        return false;
    }
}
