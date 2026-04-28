package cs680.hw11.fs;

import java.time.LocalDateTime;


public abstract class FSElement {

    protected final String name;
    protected final int size;
    protected final LocalDateTime creationTime;
    protected Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (size < 0) throw new IllegalArgumentException("size must be >= 0");
        if (creationTime == null) throw new IllegalArgumentException("creationTime required");
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
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

    public Directory getParent() {
        return parent;
    }

    /** package-private: only Directory.appendChild may set this */
    void setParent(Directory parent) {
        this.parent = parent;
    }

    

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();

    

    public abstract void accept(FSVisitor visitor);
}
