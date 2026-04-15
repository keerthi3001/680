package umbcs680.hw08.fs;

import java.time.LocalDateTime;

public abstract class FSElement {

    protected Directory parent;
    protected final String name;
    protected final LocalDateTime creationTime;

    public FSElement(Directory parent, String name, LocalDateTime creationTime) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (creationTime == null) throw new IllegalArgumentException("creationTime required");
        this.parent = parent;
        this.name = name;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return parent;
    }

    /** package-private: only Directory.appendChild may set this */
    void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public boolean isDirectory() {
        return false;
    }

    public abstract int getSize();

    public abstract void accept(FSVisitor v);
}
