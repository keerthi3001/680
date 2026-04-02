package cs680.hw06;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected final String name;
    protected final int size; // 0 for directories
    protected final LocalDateTime creationTime;
    protected Directory parent; // null for root

    protected FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (size < 0) throw new IllegalArgumentException("size must be >= 0");
        if (creationTime == null) throw new IllegalArgumentException("creationTime required");
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public String getName() { return name; }

    /** For files, this is the file size. For directories, always 0. */
    public int getSize() { return size; }

    public LocalDateTime getCreationTime() { return creationTime; }

    public Directory getParent() { return parent; }

    /** package-private: only Directory.appendChild may set this */
    void setParent(Directory p) { this.parent = p; }

    public abstract boolean isDirectory();
}
