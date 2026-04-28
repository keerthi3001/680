package cs680.hw14.fs;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime time) {
        super(parent, name, size, time);
        if (parent != null) parent.appendChild(this);
    }

    @Override public boolean isDirectory() { return false; }
    @Override public boolean isFile() { return true; }
    @Override public boolean isLink() { return false; }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }
}
