package umbcs680.hw08.fs;

import java.util.LinkedList;

public class FileSystem {

    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() {}

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    // REQUIRED by tests
    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    // REQUIRED by tests
    public void appendRootDir(Directory root) {
        if (root != null) {
            rootDirs.add(root);
        }
    }

    // RE
    public void clearRootDirs() {
        rootDirs.clear();
    }
}
