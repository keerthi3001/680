package cs680.hw07;

import java.util.LinkedList;
import java.util.List;

public class FileSystem {

    private static FileSystem fileSystem = null;
    private final LinkedList<Directory> rootDirs;

    private FileSystem() {
        rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (fileSystem == null) {
            fileSystem = new FileSystem();
        }
        return fileSystem;
    }

    /** Returns a defensive copy (HW6 style). */
    public List<Directory> getRootDirs() {
        return new LinkedList<>(this.rootDirs);
    }

    public void appendRootDir(Directory root) {
        if (root == null) throw new IllegalArgumentException("root directory cannot be null");
        this.rootDirs.add(root);
    }

    public void clearRootDirs() {
        rootDirs.clear();
    }
}
