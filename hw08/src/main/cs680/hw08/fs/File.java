package umbcs680.hw08.fs;

import java.time.LocalDateTime;

public class File extends FSElement {

    private final int size;

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, creationTime);
        if (size < 0) throw new IllegalArgumentException("size must be >= 0");
        this.size = size;

        // IMPORTANT: auto-attach into parent
        if (parent != null) { parent.appendChild(this); } // convenience link
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }
}
