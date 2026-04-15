package cs680.hw07;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    //  Match tests: new Link(parent, "name", time, target);
    public Link(Directory parent,
                String name,
                LocalDateTime creationTime,
                FSElement target) {

        // size for a link can be treated as 0
        super(parent, name, 0, creationTime);
        if (target == null) throw new IllegalArgumentException("target required");
        this.target = target;

        if (parent != null) { parent.appendChild(this); } // convenience link
    }

    public FSElement getTarget() {
        return target;
    }

    public void setTarget(FSElement target) {
        if (target == null) throw new IllegalArgumentException("target required");
        this.target = target;
    }

    @Override
    public boolean isDirectory() { return false; }

    @Override
    public boolean isFile() { return false; }

    @Override
    public boolean isLink() { return true; }
}
