package cs680.hw16.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, LocalDateTime time, FSElement target) {
        super(parent, name, 0, time);
        this.target = target;
        if (parent != null) parent.appendChild(this);
    }

    public FSElement getTarget() { return target; }

    @Override public boolean isDirectory() { return false; }
    @Override public boolean isFile() { return false; }
    @Override public boolean isLink() { return true; }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }
}
